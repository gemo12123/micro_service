package org.mytest.test.service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.mytest.test.entity.HelloGrpc;
import org.springframework.stereotype.Service;

/**
 * @author gemo
 * @date 2023/7/8 21:29
 */
@Slf4j
@Service
public class GrpcWebService {
    @GrpcClient("grpc-springboot-server")
    private HelloGrpcServiceGrpc.HelloGrpcServiceBlockingStub blockingStub;

    public String blockingExecute() throws InvalidProtocolBufferException {
        HelloGrpc.Response response = blockingStub.request(HelloGrpc.Request.newBuilder()
                .setParam("Springboot client request!")
                .build());
        log.info("Server response status:{}，result:{}!", response.getStatus(), response.getResult());
        return JsonFormat.printer().includingDefaultValueFields().print(response);
    }
}
