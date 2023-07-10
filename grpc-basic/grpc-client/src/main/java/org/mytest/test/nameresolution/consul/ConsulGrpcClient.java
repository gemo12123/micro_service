package org.mytest.test.nameresolution.consul;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolverRegistry;
import lombok.extern.slf4j.Slf4j;
import org.mytest.test.entity.HelloGrpc;
import org.mytest.test.service.HelloGrpcServiceGrpc;

/**
 * @author gemo
 * @date 2023/7/10 21:07
 */
@Slf4j
public class ConsulGrpcClient {
    /**
     * 1. 原有的开发方式保留
     * 2. 引入自定义名字解析
     * 3. 引入负载均衡的算法
     *
     * @param args
     */
    public static void main(String[] args) {
        //1 引入新的命名解析
        NameResolverRegistry.getDefaultRegistry().register(new CustomNameResolverProvider());

        // 客户端开发，target对应server端注册的name
        ManagedChannel channel = ManagedChannelBuilder.forTarget("gRpc-service")
                .usePlaintext()
                //3 引入负载均衡算法 round_robin轮训 负载均衡
                .defaultLoadBalancingPolicy("round_robin")
                .build();
        try {
            for (int i = 0; i < 3; i++) {
                HelloGrpcServiceGrpc.HelloGrpcServiceBlockingStub stub = HelloGrpcServiceGrpc.newBlockingStub(channel);
                HelloGrpc.Response response = stub.request(HelloGrpc.Request.newBuilder()
                        .setParam("client request")
                        .build());
                log.info("Server response status:{}，result:{}!", response.getStatus(), response.getResult());
                Thread.sleep(2000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.shutdown();
        }
    }
}
