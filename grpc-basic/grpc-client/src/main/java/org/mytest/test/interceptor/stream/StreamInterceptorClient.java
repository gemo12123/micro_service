package org.mytest.test.interceptor.stream;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.mytest.test.entity.HelloGrpc;
import org.mytest.test.service.HelloGrpcServiceGrpc;

import java.util.concurrent.TimeUnit;

/**
 * @author gemo
 * @date 2023/7/9 10:36
 */
@Slf4j
public class StreamInterceptorClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8998)
                .intercept(new StreamClientInterceptor())
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
            for (int i = 0; i < 3; i++) {
                requestStreamObserver.onNext(HelloGrpc.Request.newBuilder()
                        .setParam("Bidirectional stream client request! this is loop[" + i + "]")
                        .build());
                Thread.sleep(2000);
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
