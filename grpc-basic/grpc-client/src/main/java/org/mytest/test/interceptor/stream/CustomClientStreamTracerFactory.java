package org.mytest.test.interceptor.stream;

import io.grpc.ClientStreamTracer;
import io.grpc.Metadata;

/**
 * @author gemo
 * @date 2023/7/9 18:28
 */
public class CustomClientStreamTracerFactory<ReqT, RespT> extends ClientStreamTracer.Factory {
    @Override
    public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo info, Metadata headers) {
        return new CustomClientStreamTracer<>();
    }
}
