package org.mytest.test.config;

import io.grpc.ServerInterceptor;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.mytest.test.interceptor.GrpcServerInterceptor;
import org.springframework.context.annotation.Configuration;

/**
 * @author gemo
 * @date 2023/7/11 20:46
 */
@Configuration
public class GrpcConfig {

    @GrpcGlobalServerInterceptor
    public ServerInterceptor getServerInterceptor() {
        return new GrpcServerInterceptor();
    }
}
