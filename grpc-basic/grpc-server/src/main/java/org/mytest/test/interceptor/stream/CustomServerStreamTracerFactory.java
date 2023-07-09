package org.mytest.test.interceptor.stream;

import io.grpc.Metadata;
import io.grpc.ServerStreamTracer;

/**
 * @author gemo
 * @date 2023/7/9 18:59
 */
public class CustomServerStreamTracerFactory extends ServerStreamTracer.Factory {
    @Override
    public ServerStreamTracer newServerStreamTracer(String fullMethodName, Metadata headers) {
        return new CustomServerStreamTracer();
    }
}
