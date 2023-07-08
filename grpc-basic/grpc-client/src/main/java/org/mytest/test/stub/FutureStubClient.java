package org.mytest.test.stub;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.mytest.test.entity.HelloGrpc;
import org.mytest.test.service.HelloGrpcServiceGrpc;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * FutureStub
 *
 * @author gemo
 * @date 2023/7/8 18:21
 */
@Slf4j
public class FutureStubClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8998)
                .usePlaintext()
                .build();
        try {
            HelloGrpcServiceGrpc.HelloGrpcServiceFutureStub stub = HelloGrpcServiceGrpc.newFutureStub(channel);
            ListenableFuture<HelloGrpc.Response> requestFuture = stub.request(HelloGrpc.Request.newBuilder()
                    .setParam("server stream non-blocking client request!")
                    .build());

            log.info("Execute is end....");
            // 阻塞等待结果响应
//            HelloGrpc.Response response = requestFuture.get();
//            log.info("Server response: {}", response.getResult());

            // 非阻塞，但无法获取response
//            requestFuture.addListener(()->{
//                log.info("async exected is end....");
//            }, Executors.newCachedThreadPool());

            // 非阻塞
            Futures.addCallback(requestFuture,
                    new FutureCallback<HelloGrpc.Response>() {
                        @Override
                        public void onSuccess(HelloGrpc.Response response) {
                            log.info("Server response: {}", response.getResult());
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            log.info("Server response: {}", t.getMessage());
                        }
                    }, Executors.newCachedThreadPool());

            log.info("Programmer is end....");
            channel.awaitTermination(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.shutdown();
        }
    }
}
