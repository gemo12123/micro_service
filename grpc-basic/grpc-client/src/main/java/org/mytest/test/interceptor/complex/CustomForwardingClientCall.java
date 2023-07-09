package org.mytest.test.interceptor.complex;

import io.grpc.Attributes;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptors;
import io.grpc.Metadata;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;

/**
 * 适用于控制、拦截、请求发送各个环节
 *
 * @author gemo
 * @date 2023/7/9 11:05
 */
@Slf4j
public class CustomForwardingClientCall<ReqT, RespT> extends ClientInterceptors.CheckedForwardingClientCall<ReqT, RespT> {

    protected CustomForwardingClientCall(ClientCall<ReqT, RespT> delegate) {
        super(delegate);
    }

    /**
     * 检查是否需要调用，如果需要则要执行delegate().start()方法的调用
     *
     * @param responseListener
     * @param headers
     * @throws Exception
     */
    @Override
    protected void checkedStart(Listener<RespT> responseListener, Metadata headers) throws Exception {
        log.info("checkStart execute");
//        delegate().start(responseListener, headers);
        delegate().start(new CustomCallListener<>(responseListener), headers);
    }

    /**
     * 消息发送缓冲区
     *
     * @param message message to be sent to the server.
     */
    @Override
    public void sendMessage(ReqT message) {
        log.info("sendMessage start...");
        super.sendMessage(message);
        log.info("sendMessage end...");
    }

    /**
     * 指定发送消息的数量
     *
     * @param numMessages the requested number of messages to be delivered to the listener. Must be
     *                    non-negative.
     */
    @Override
    public void request(int numMessages) {
        log.info("request start..." + numMessages);
        super.request(numMessages);
        log.info("request end..." + numMessages);
    }

    /**
     * 请求时连接异常关闭
     *
     * @param message if not {@code null}, will appear as the description of the CANCELLED status
     * @param cause   if not {@code null}, will appear as the cause of the CANCELLED status
     */
    @Override
    public void cancel(@Nullable String message, @Nullable Throwable cause) {
        log.info("cancel start...");
        super.cancel(message, cause);
        log.info("cancel end...");
    }

    /**
     * 消息发送到缓冲区后开启半连接
     * 此时请求消息无法发送，但是可以接受响应的消息
     */
    @Override
    public void halfClose() {
        log.info("halfClose start...");
        super.halfClose();
        log.info("halfClose end...");
    }

    @Override
    public void setMessageCompression(boolean enabled) {
        log.info("setMessageCompression start...");
        super.setMessageCompression(enabled);
        log.info("setMessageCompression end...");
    }

    @Override
    public boolean isReady() {
        log.info("isReady start...");
        boolean ready = super.isReady();
        log.info("isReady end...");
        return ready;
    }

    @Override
    public Attributes getAttributes() {
        log.info("getAttributes start...");
        Attributes attributes = super.getAttributes();
        log.info("getAttributes end...");
        return attributes;
    }
}
