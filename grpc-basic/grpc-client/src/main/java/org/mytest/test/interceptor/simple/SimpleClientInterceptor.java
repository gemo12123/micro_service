package org.mytest.test.interceptor.simple;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gemo
 * @date 2023/7/9 10:35
 */
@Slf4j
public class SimpleClientInterceptor implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        log.info("SimpleClientInterceptor execute!");
        return next.newCall(method, callOptions);
    }
}
