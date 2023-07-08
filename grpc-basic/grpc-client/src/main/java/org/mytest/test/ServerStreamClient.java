package org.mytest.test;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.mytest.test.entity.HelloGrpc;
import org.mytest.test.service.HelloGrpcServiceGrpc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author gemo
 * @date 2023/7/7 22:04
 */
@Slf4j
public class ServerStreamClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8998)
                .usePlaintext()
                .build();
        try {
            // 阻塞式
//            blockingMethod(channel);
            // 非阻塞式
            nonBlockingMethod(channel);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.shutdown();
        }
    }

    private static void blockingMethod(ManagedChannel channel) {
        HelloGrpcServiceGrpc.HelloGrpcServiceBlockingStub stub = HelloGrpcServiceGrpc.newBlockingStub(channel);
        Iterator<HelloGrpc.Response> responseIterator = stub.serverStream(HelloGrpc.Request.newBuilder()
//                .setParam("server stream blocking client request!")
                .setParam("server stream blocking client request! error!")
                .build());

        while (responseIterator.hasNext()){
            HelloGrpc.Response response = responseIterator.next();
            log.info("Server response status:{}，result:{}!",response.getStatus(),response.getResult());
        }
        log.info("Loop is ending....");
    }

    private static void nonBlockingMethod(ManagedChannel channel) throws InterruptedException {
        HelloGrpcServiceGrpc.HelloGrpcServiceStub stub = HelloGrpcServiceGrpc.newStub(channel);
        stub.serverStream(HelloGrpc.Request.newBuilder()
//                .setParam("server stream non-blocking client request!")
                .setParam("server stream non-blocking client request! error!")
                .build(), new StreamObserver<HelloGrpc.Response>() {
            final List<HelloGrpc.Response> responseList=new ArrayList<>();
            @Override
            public void onNext(HelloGrpc.Response response) {
                log.info("Server response status:{}，result:{}!",response.getStatus(),response.getResult());
                responseList.add(response);
            }
            @Override
            public void onError(Throwable throwable) {
                log.error("Server response is error!");
            }
            @Override
            public void onCompleted() {
                log.info("Server response is completed, the total number of server responses is {}!",responseList.size());
            }
        });
        log.info("Request is ending....");
        // 非阻塞方，必须await，否则程序运行后直接结束
        channel.awaitTermination(6, TimeUnit.SECONDS);
    }
}
