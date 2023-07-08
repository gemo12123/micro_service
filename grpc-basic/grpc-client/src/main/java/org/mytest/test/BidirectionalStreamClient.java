package org.mytest.test;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.mytest.test.entity.HelloGrpc;
import org.mytest.test.service.HelloGrpcServiceGrpc;

import java.util.concurrent.TimeUnit;

/**
 * @author gemo
 * @date 2023/7/7 22:04
 */
@Slf4j
public class BidirectionalStreamClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8998)
                .usePlaintext()
                .build();
        try {
            HelloGrpcServiceGrpc.HelloGrpcServiceStub stub = HelloGrpcServiceGrpc.newStub(channel);
            StreamObserver<HelloGrpc.Request> requestStreamObserver = stub.bidirectionalStream(new StreamObserver<HelloGrpc.Response>() {
                @Override
                public void onNext(HelloGrpc.Response response) {
                    log.info("Server response status:{}，result:{}!", response.getStatus(), response.getResult());
                }
                @Override
                public void onError(Throwable t) {
                    log.error("Server response is error!", t);
                }
                @Override
                public void onCompleted() {
                    log.info("Server response is completed!");
                }
            });
            for (int i = 0; i < 10; i++) {
                requestStreamObserver.onNext(HelloGrpc.Request.newBuilder()
                        .setParam("Bidirectional stream client request! this is loop[" + i + "]")
                        .build());
            }
            requestStreamObserver.onCompleted();
            // awit等待响应
            channel.awaitTermination(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.shutdown();
        }
    }
}
