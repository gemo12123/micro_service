package org.mytest.test.nameresolution.consul;

import com.google.common.net.HostAndPort;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import com.orbitz.consul.model.agent.Registration;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.mytest.test.service.HelloGrpcServiceImpl;

import java.io.IOException;
import java.util.Collections;
import java.util.Random;

/**
 * @author gemo
 * @date 2023/7/10 20:50
 */
public class ConsulGrpcServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        int port = new Random().nextInt(65535);
        Server server = ServerBuilder.forPort(port)
                .addService(new HelloGrpcServiceImpl())
                .build();

        server.start();
        // 将服务注册到consul
        registerToConsul("127.0.0.1", port);
        server.awaitTermination();
    }

    /**
     * 服务注册
     *
     * @param address gRpc服务端地址
     * @param port    gRpc服务端端口
     */
    private static void registerToConsul(String address, int port) {
        String serviceName = "gRpc-service-" + address + "-" + port;

        // 连接到consul服务器
        Consul consul = Consul.builder().withHostAndPort(HostAndPort.fromParts("127.0.0.1", 8500)).build();
        // 获得consul客户端对象
        AgentClient client = consul.agentClient();

        ImmutableRegistration service = ImmutableRegistration.builder()
                .id(serviceName)
                .name("gRpc-service")
                .address(address)
                .port(port)
                .tags(Collections.singletonList("server"))
                .meta(Collections.singletonMap("version", "1.0"))
                // 健康检查，支持ttl http tcp方式的健康检查
                .check(Registration.RegCheck.tcp(address + ":" + port, 10))
                .build();

        client.register(service);
    }
}
