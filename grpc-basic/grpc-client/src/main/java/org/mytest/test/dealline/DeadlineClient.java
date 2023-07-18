package org.mytest.test.dealline;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.mytest.test.entity.HelloGrpc;
import org.mytest.test.service.HelloGrpcServiceGrpc;

import java.util.concurrent.TimeUnit;

@Slf4j
public class DeadlineClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8998)
                .usePlaintext()
                .build();
        try {
            HelloGrpcServiceGrpc.HelloGrpcServiceBlockingStub stub = HelloGrpcServiceGrpc.newBlockingStub(channel);
            stub = stub.withDeadlineAfter(3, TimeUnit.SECONDS);
            HelloGrpc.Response response = stub.request(HelloGrpc.Request.newBuilder()
                    .setParam("client request!deadline!")
                    .build());
            log.info("Server response status:{}，result:{}!",response.getStatus(),response.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.shutdown();
        }
    }
}
