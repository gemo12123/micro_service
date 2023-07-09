package org.mytest.test.interceptor.stream;

import io.grpc.ServerStreamTracer;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gemo
 * @date 2023/7/9 18:55
 */
@Slf4j
public class CustomServerStreamTracer extends ServerStreamTracer {

    /**
     * 获取请求流消息的编号
     *
     * @param seqNo the sequential number of the message within the stream, starting from 0.  It can
     *              be used to correlate with {@link #inboundMessageRead} for the same message.
     */
    @Override
    public void inboundMessage(int seqNo) {
        log.info("请求消息编号 {}", seqNo);
        super.inboundMessage(seqNo);
    }

    /**
     * 获得请求头大小
     *
     * @param bytes
     */
    @Override
    public void inboundWireSize(long bytes) {
        log.info("请求消息大小 {}", bytes);
        super.inboundWireSize(bytes);
    }

    /**
     * 获得请求消息信息
     *
     * @param seqNo                    the sequential number of the message within the stream, starting from 0.  It can
     *                                 be used to correlate with {@link #inboundMessage(int)} for the same message.
     * @param optionalWireSize         the wire size of the message. -1 if unknown
     * @param optionalUncompressedSize the uncompressed serialized size of the message. -1 if unknown
     */
    @Override
    public void inboundMessageRead(int seqNo, long optionalWireSize, long optionalUncompressedSize) {
        log.info("server: 获得client发送的请求消息 ...{} {} {}", seqNo, optionalWireSize, optionalUncompressedSize);
        super.inboundMessageRead(seqNo, optionalWireSize, optionalUncompressedSize);
    }

    /**
     * 获得请求消息未压缩大小
     *
     * @param bytes
     */
    @Override
    public void inboundUncompressedSize(long bytes) {
        log.info("请求消息未压缩大小 {}", bytes);
        super.inboundUncompressedSize(bytes);
    }

    /**
     * 获得响应消息编号
     *
     * @param seqNo the sequential number of the message within the stream, starting from 0.  It can
     *              be used to correlate with {@link #outboundMessageSent} for the same message.
     */
    @Override
    public void outboundMessage(int seqNo) {
        log.info("响应消息编号 {}", seqNo);
        super.outboundMessage(seqNo);
    }


    /**
     * 获得响应消息信息
     *
     * @param seqNo                    the sequential number of the message within the stream, starting from 0.  It can
     *                                 be used to correlate with {@link #outboundMessage(int)} for the same message.
     * @param optionalWireSize         the wire size of the message. -1 if unknown
     * @param optionalUncompressedSize the uncompressed serialized size of the message. -1 if unknown
     */
    @Override
    public void outboundMessageSent(int seqNo, long optionalWireSize, long optionalUncompressedSize) {
        log.info("server: 响应数据的拦截 ...{} {} {}", seqNo, optionalWireSize, optionalUncompressedSize);
        super.outboundMessageSent(seqNo, optionalWireSize, optionalUncompressedSize);
    }

    /**
     * 获得响应消息大小
     *
     * @param bytes
     */
    @Override
    public void outboundWireSize(long bytes) {
        log.info("响应消息大小 {}", bytes);
        super.outboundWireSize(bytes);
    }

    /**
     * 获得响应消息未压缩大小
     *
     * @param bytes
     */
    @Override
    public void outboundUncompressedSize(long bytes) {
        log.info("响应消息未压缩大小 {}", bytes);
        super.outboundUncompressedSize(bytes);
    }
}
