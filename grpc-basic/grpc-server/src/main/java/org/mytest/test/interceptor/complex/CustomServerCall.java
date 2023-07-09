package org.mytest.test.interceptor.complex;

import io.grpc.ForwardingServerCall;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.Status;
import lombok.extern.slf4j.Slf4j;

/**
 * 服务端响应拦截
 *
 * @author gemo
 * @date 2023/7/9 17:51
 */
@Slf4j
public class CustomServerCall<ReqT, RespT> extends ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT> {
    protected CustomServerCall(ServerCall<ReqT, RespT> delegate) {
        super(delegate);
    }

    /**
     * 指定发送响应消息的数量
     *
     * @param numMessages the requested number of messages to be delivered to the listener.
     */
    @Override
    public void request(int numMessages) {
        log.info("requesting start..." + numMessages);
        super.request(numMessages);
        log.info("requesting end..." + numMessages);
    }

    /**
     * 响应头信息发送
     *
     * @param headers metadata to send prior to any response body.
     */
    @Override
    public void sendHeaders(Metadata headers) {
        log.info("sendHeaders start...");
        super.sendHeaders(headers);
        log.info("sendHeaders end...");
    }

    /**
     * 响应信息发送
     *
     * @param message response message.
     */
    @Override
    public void sendMessage(RespT message) {
        log.info("sendMessage start...");
        super.sendMessage(message);
        log.info("sendMessage end...");
    }

    /**
     * 连接关闭
     *
     * @param status
     * @param trailers
     */
    @Override
    public void close(Status status, Metadata trailers) {
        log.info("close start...");
        super.close(status, trailers);
        log.info("close end...");
    }
}
