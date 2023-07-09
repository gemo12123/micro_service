package org.mytest.test.interceptor.complex;

import io.grpc.ClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.Status;
import lombok.extern.slf4j.Slf4j;

/**
 * 请求响应监听器，监听一元RPC
 *
 * @author gemo
 * @date 2023/7/9 11:06
 */
@Slf4j
public class CustomCallListener<RespT> extends ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT> {

    protected CustomCallListener(ClientCall.Listener<RespT> delegate) {
        super(delegate);
    }

    /**
     * 响应头信息
     * 会在首次onNext调用后监听到数据
     *
     * @param headers containing metadata sent by the server at the start of the response.
     */
    @Override
    public void onHeaders(Metadata headers) {
        log.info("onHeaders start...");
        super.onHeaders(headers);
        log.info("onHeaders end...");
    }

    /**
     * 响应数据
     * 会在onCompleted调用后监听到数据
     *
     * @param message returned by the server
     */
    @Override
    public void onMessage(RespT message) {
        log.info("onMessage start...");
        super.onMessage(message);
        log.info("onMessage end...");
    }

    /**
     * 连接关闭时调用
     *
     * @param status   the result of the remote call.
     * @param trailers metadata provided at call completion.
     */
    @Override
    public void onClose(Status status, Metadata trailers) {
        log.info("onClose start...");
        super.onClose(status, trailers);
        log.info("onClose end...");
    }

    @Override
    public void onReady() {
        log.info("onReady start...");
        super.onReady();
        log.info("onReady end...");
    }
}
