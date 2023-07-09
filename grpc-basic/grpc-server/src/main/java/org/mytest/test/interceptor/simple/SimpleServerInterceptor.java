package org.mytest.test.interceptor.simple;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gemo
 * @date 2023/7/9 17:33
 */
@Slf4j
public class SimpleServerInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        log.info("SimpleServerInterceptor interceptCall");
        return next.startCall(call, headers);
    }
}
