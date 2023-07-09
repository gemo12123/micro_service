package org.mytest.test.interceptor.complex;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;

/**
 * @author gemo
 * @date 2023/7/9 17:38
 */
public class ComplexServerInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        return new CustomServerCallListener<>(next.startCall(new CustomServerCall<>(call), headers));
    }
}
