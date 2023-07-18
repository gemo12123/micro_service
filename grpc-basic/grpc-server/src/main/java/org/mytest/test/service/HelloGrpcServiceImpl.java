package org.mytest.test.service;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.mytest.test.entity.HelloGrpc;
import org.mytest.test.service.HelloGrpcServiceGrpc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gemo
 * @date 2023/7/7 21:36
 */
@Slf4j
public class HelloGrpcServiceImpl extends HelloGrpcServiceGrpc.HelloGrpcServiceImplBase {

    @Override
    public void request(HelloGrpc.Request request, StreamObserver<HelloGrpc.Response> responseObserver) {
        String param = request.getParam();
        log.info("Request param:{}", param);
        HelloGrpc.Response response = HelloGrpc.Response.newBuilder()
                .setStatus(param.length() > 3 ? HelloGrpc.Status.SUCCESS : HelloGrpc.Status.ERROR)
                .setResult("server response [" + param + "]")
                .build();
        if (param.contains("deadline")) {
            try {
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("sleep end.....");
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void serverStream(HelloGrpc.Request request, StreamObserver<HelloGrpc.Response> responseObserver) {
        String param = request.getParam();
        log.info("Server stream request param:{}", param);
        for (int i = 0; i < 10; i++) {
            responseObserver.onNext(HelloGrpc.Response.newBuilder()
                    .setStatus(i % 2 == 0 ? HelloGrpc.Status.SUCCESS : HelloGrpc.Status.ERROR)
                    .setResult("this is loop[" + i + "]")
                    .build());
            if (param.contains("error") && i % 2 == 0) {
                throw new RuntimeException();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<HelloGrpc.Request> clientStream(StreamObserver<HelloGrpc.Response> responseObserver) {
        return new StreamObserver<HelloGrpc.Request>() {
            List<HelloGrpc.Request> requestList=new ArrayList<>();

            @Override
            public void onNext(HelloGrpc.Request request) {
                String param = request.getParam();
                log.info("Client request param:{}!", param);
                requestList.add(request);
            }

            @Override
            public void onError(Throwable t) {
                log.error("Client is error!", t);
            }

            @Override
            public void onCompleted() {
                log.info("Client is completed!");
                responseObserver.onNext(HelloGrpc.Response.newBuilder()
                      .setStatus(HelloGrpc.Status.SUCCESS)
                      .setResult("Server stream received " + requestList.size() + " requests")
                      .build());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<HelloGrpc.Request> bidirectionalStream(StreamObserver<HelloGrpc.Response> responseObserver) {
        return new StreamObserver<HelloGrpc.Request>() {
            List<HelloGrpc.Request> requestList=new ArrayList<>();
            @Override
            public void onNext(HelloGrpc.Request request) {
                String param = request.getParam();
                log.info("Bidirectional stream request param:{}!", param);
                requestList.add(request);
                responseObserver.onNext(HelloGrpc.Response.newBuilder()
                     .setStatus(HelloGrpc.Status.SUCCESS)
                     .setResult("Server stream has received " + requestList.size() + " requests")
                     .build());
            }
            @Override
            public void onError(Throwable t) {
                log.error("Bidirectional stream is error!", t);
            }
            @Override
            public void onCompleted() {
                log.info("Bidirectional stream is completed!");
                responseObserver.onNext(HelloGrpc.Response.newBuilder()
                    .setStatus(HelloGrpc.Status.SUCCESS)
                    .setResult("Server response is completed, the total number of server received is " + requestList.size() + " requests")
                    .build());
                responseObserver.onCompleted();
            }
        };
    }
}
