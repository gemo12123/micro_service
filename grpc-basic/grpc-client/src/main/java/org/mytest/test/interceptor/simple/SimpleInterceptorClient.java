package org.mytest.test.interceptor.simple;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.mytest.test.entity.HelloGrpc;
import org.mytest.test.service.HelloGrpcServiceGrpc;

/**
 * @author gemo
 * @date 2023/7/9 10:36
 */
@Slf4j
public class SimpleInterceptorClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8998)
                .intercept(new SimpleClientInterceptor())
                .usePlaintext()
                .build();
        try {
            HelloGrpcServiceGrpc.HelloGrpcServiceBlockingStub stub = HelloGrpcServiceGrpc.newBlockingStub(channel);
            HelloGrpc.Response response = stub.request(HelloGrpc.Request.newBuilder()
                    .setParam("client request")
                    .build());
            log.info("Server response status:{}，result:{}!", response.getStatus(), response.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.shutdown();
        }
    }
}
