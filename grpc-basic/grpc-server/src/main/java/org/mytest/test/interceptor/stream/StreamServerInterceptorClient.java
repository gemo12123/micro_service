package org.mytest.test.interceptor.stream;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.mytest.test.service.HelloGrpcServiceImpl;

import java.io.IOException;

/**
 * @author gemo
 * @date 2023/7/9 17:36
 */
public class StreamServerInterceptorClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8998)
                .addService(new HelloGrpcServiceImpl())
                .addStreamTracerFactory(new CustomServerStreamTracerFactory())
                .build();

        server.start();
        server.awaitTermination();
    }
}
