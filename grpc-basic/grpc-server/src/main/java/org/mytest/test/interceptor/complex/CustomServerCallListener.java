package org.mytest.test.interceptor.complex;

import io.grpc.ForwardingServerCallListener;
import io.grpc.ServerCall;
import lombok.extern.slf4j.Slf4j;

/**
 * 监听客户端请求
 *
 * @author gemo
 * @date 2023/7/9 17:39
 */
@Slf4j
public class CustomServerCallListener<ReqT> extends ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT> {
    protected CustomServerCallListener(ServerCall.Listener<ReqT> delegate) {
        super(delegate);
    }

    @Override
    protected ServerCall.Listener<ReqT> delegate() {
        log.info("delegate start...");
        ServerCall.Listener<ReqT> delegate = super.delegate();
        log.info("delegate end...");
        return delegate;
    }

    /**
     * 准备接受请求数据
     */
    @Override
    public void onReady() {
        log.info("onReady start...");
        super.onReady();
        log.info("onReady end...");
    }

    /**
     * 接收到请求数据
     *
     * @param message a received request message.
     */
    @Override
    public void onMessage(ReqT message) {
        log.info("onMessage start...");
        super.onMessage(message);
        log.info("onMessage end...");
    }

    /**
     * 监听到了半连接
     */
    @Override
    public void onHalfClose() {
        log.info("onHalfClose start...");
        super.onHalfClose();
        log.info("onHalfClose end...");
    }

    /**
     * 异常关闭
     */
    @Override
    public void onCancel() {
        log.info("onCancel start...");
        super.onCancel();
        log.info("onCancel end...");
    }

    /**
     * 服务端执行了onComplete
     */
    @Override
    public void onComplete() {
        log.info("onComplete start...");
        super.onComplete();
        log.info("onComplete end...");
    }
}
