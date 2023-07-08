package org.mytest.test.stub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.mytest.test.entity.HelloGrpc;
import org.mytest.test.service.HelloGrpcServiceGrpc;

import java.util.concurrent.TimeUnit;

/**
 * Stub
 *
 * @author gemo
 * @date 2023/7/8 19:15
 */
@Slf4j
public class StubClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8998)
                .usePlaintext()
                .build();
        try {
            HelloGrpcServiceGrpc.HelloGrpcServiceStub stub = HelloGrpcServiceGrpc.newStub(channel);
            stub.request(HelloGrpc.Request.newBuilder()
                    .setParam("client request")
                    .build(), new StreamObserver<HelloGrpc.Response>() {
                @Override
                public void onNext(HelloGrpc.Response response) {
                    log.info("Server response status:{}，result:{}!", response.getStatus(), response.getResult());
                }

                @Override
                public void onError(Throwable t) {
                    log.info("Server response is error!");
                }

                @Override
                public void onCompleted() {
                    log.info("Server response is completed!");
                }
            });
            channel.awaitTermination(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.shutdown();
        }
    }
}
