package org.mytest.test.service;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.mytest.test.entity.HelloGrpc;
import org.mytest.test.service.HelloGrpcServiceGrpc;

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
}