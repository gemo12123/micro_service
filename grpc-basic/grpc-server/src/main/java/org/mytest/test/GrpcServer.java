package org.mytest.test;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.mytest.test.service.HelloGrpcServiceImpl;

import java.io.IOException;

/**
 * @author gemo
 * @date 2023/7/7 22:02
 */
public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8998)
                .addService(new HelloGrpcServiceImpl())
                .build();

        server.start();
        server.awaitTermination();
    }
}
