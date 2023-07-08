package org.mytest.test.stub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.mytest.test.entity.HelloGrpc;
import org.mytest.test.service.HelloGrpcServiceGrpc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * BlockingStub
 *
 * @author gemo
 * @date 2023/7/8 17:48
 */
@Slf4j
public class BlockingStubClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8998)
                .usePlaintext()
                .build();
        try {
            // 一元RPC
//            blockingSimpleRpcExecute(channel);
            // 服务端流式RPC
            blockingServerStreamRpcExecute(channel);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.shutdown();
        }
    }

    /**
     * 阻塞式一元RPC
     *
     * @param channel
     */
    private static void blockingSimpleRpcExecute(ManagedChannel channel) {
        HelloGrpcServiceGrpc.HelloGrpcServiceBlockingStub stub = HelloGrpcServiceGrpc.newBlockingStub(channel);
        HelloGrpc.Response response = stub.request(HelloGrpc.Request.newBuilder()
                .setParam("client request")
                .build());
        log.info("Server response status:{}，result:{}!", response.getStatus(), response.getResult());
    }

    /**
     * 阻塞式服务端流式RPC
     *
     * @param channel
     */
    private static void blockingServerStreamRpcExecute(ManagedChannel channel) throws InterruptedException {
        HelloGrpcServiceGrpc.HelloGrpcServiceStub stub = HelloGrpcServiceGrpc.newStub(channel);
        stub.serverStream(HelloGrpc.Request.newBuilder()
                .setParam("server stream non-blocking client request!")
//                .setParam("server stream non-blocking client request! error!")
                .build(), new StreamObserver<HelloGrpc.Response>() {
            final List<HelloGrpc.Response> responseList = new ArrayList<>();

            @Override
            public void onNext(HelloGrpc.Response response) {
                log.info("Server response status:{}，result:{}!", response.getStatus(), response.getResult());
                responseList.add(response);
            }

            @Override
            public void onError(Throwable throwable) {
                log.error("Server response is error!", throwable);
            }

            @Override
            public void onCompleted() {
                log.info("Server response is completed, the total number of server responses is {}!", responseList.size());
            }
        });
        log.info("Request is ending....");
        // 非阻塞方式，必须await，否则程序运行后直接结束
        channel.awaitTermination(6, TimeUnit.SECONDS);
    }
}
