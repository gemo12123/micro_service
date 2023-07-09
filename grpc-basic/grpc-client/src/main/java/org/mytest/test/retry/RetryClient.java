package org.mytest.test.retry;

import com.alibaba.fastjson.JSONObject;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.mytest.test.entity.HelloGrpc;
import org.mytest.test.service.HelloGrpcServiceGrpc;

/**
 * @author gemo
 * @date 2023/7/9 19:14
 */
@Slf4j
public class RetryClient {
    private static final String CONFIG = "{\n" +
            "  \"methodConfig\": [\n" +
            "    {\n" +
            "      \"name\": [\n" +
            "        {\n" +
            "          \"service\": \"org.mytest.test.service.HelloGrpcService\",\n" + // protobuf定义的服务的名字，带包名
            "          \"method\": \"request\"\n" +   //服务方法名字
            "        }\n" +
            "      ],\n" +
            "      \"retryPolicy\": {\n" +
            "        \"maxAttempts\": \"3\",\n" +   //重试的次数
            "        \"initialBackoff\": \"5s\",\n" + //初始重试的延迟时间
            "        \"maxBackoff\": \"30s\",       \n" +    //最大重试的延迟时间
            "        \"backoffMultiplier\": \"2\",   \n" +  //退避指数 每一次重试的时间间隔，不是不固定，2 4 6...
            "        \"retryableStatusCodes\": [ \n" +  //只有当接受到了这个数组中描述的异常，才会发起重试
            "          \"UNAVAILABLE\"\n" +
            "        ]\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8998)
                .usePlaintext()
                .defaultServiceConfig(JSONObject.parseObject(CONFIG))
                .enableRetry()
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
