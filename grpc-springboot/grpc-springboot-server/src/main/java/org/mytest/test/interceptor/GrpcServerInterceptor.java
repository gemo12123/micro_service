package org.mytest.test.interceptor;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gemo
 * @date 2023/7/11 20:45
 */
@Slf4j
//@GrpcGlobalServerInterceptor
public class GrpcServerInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        log.info("grpc server interceptor");
        return next.startCall(call, headers);
    }
}
