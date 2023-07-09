package org.mytest.test.interceptor.complex;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gemo
 * @date 2023/7/9 11:05
 */
@Slf4j
public class ComplexClientInterceptor implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        log.info("ComplexClientInterceptor start!");
        CustomForwardingClientCall<ReqT, RespT> clientCall = new CustomForwardingClientCall<>(next.newCall(method, callOptions));
        log.info("ComplexClientInterceptor end!");
        return clientCall;
    }
}
