package org.mytest.test.interceptor.stream;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gemo
 * @date 2023/7/9 18:21
 */
@Slf4j
public class StreamClientInterceptor implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        callOptions = callOptions.withStreamTracerFactory(new CustomClientStreamTracerFactory<>());
        return next.newCall(method, callOptions);
    }
}
