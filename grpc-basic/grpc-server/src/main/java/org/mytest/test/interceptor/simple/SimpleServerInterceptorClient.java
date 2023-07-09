package org.mytest.test.interceptor.simple;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.mytest.test.service.HelloGrpcServiceImpl;

import java.io.IOException;

/**
 * @author gemo
 * @date 2023/7/9 17:36
 */
public class SimpleServerInterceptorClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8998)
                .addService(new HelloGrpcServiceImpl())
                .intercept(new SimpleServerInterceptor())
                .build();

        server.start();
        server.awaitTermination();
    }
}
