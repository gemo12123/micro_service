package org.mytest.test.interceptor.stream;

import io.grpc.ClientStreamTracer;
import io.grpc.Metadata;
import lombok.extern.slf4j.Slf4j;

/**
 * 用于客户端流式拦截，既拦截请求又拦截响应
 *
 * @author gemo
 * @date 2023/7/9 18:22
 */
@Slf4j
public class CustomClientStreamTracer<ReqT, RespT> extends ClientStreamTracer {

    /**
     * 用于客户端发送请求头
     */
    @Override
    public void outboundHeaders() {
        log.info("client: 用于输出请求头.....");
        super.outboundHeaders();
    }

    /**
     * 设置客户端请求流消息的编号，每条消息对应一个编号，默认从0开始每条消息自增1
     *
     * @param seqNo the sequential number of the message within the stream, starting from 0.  It can
     *              be used to correlate with {@link #outboundMessageSent} for the same message.
     */
    @Override
    public void outboundMessage(int seqNo) {
        log.info("client: 设置流消息的编号 {} ", seqNo);
        super.outboundMessage(seqNo);
    }

    /**
     * 获得客户端请求未压缩消息的大小
     *
     * @param bytes
     */
    @Override
    public void outboundUncompressedSize(long bytes) {
        log.info("client: 获得未压缩消息的大小 {} ", bytes);
        super.outboundUncompressedSize(bytes);
    }

    /**
     * 用于获得客户端请求的大小
     *
     * @param bytes
     */
    @Override
    public void outboundWireSize(long bytes) {
        log.info("client: 用于获得 输出消息的大小 {} ", bytes);
        super.outboundWireSize(bytes);
    }

    /**
     * 拦截客户端请求消息发送
     *
     * @param seqNo                    the sequential number of the message within the stream, starting from 0.  It can
     *                                 be used to correlate with {@link #outboundMessage(int)} for the same message.
     * @param optionalWireSize         the wire size of the message. -1 if unknown
     * @param optionalUncompressedSize the uncompressed serialized size of the message. -1 if unknown
     */
    @Override
    public void outboundMessageSent(int seqNo, long optionalWireSize, long optionalUncompressedSize) {
        log.info("client: 监控请求操作 outboundMessageSent，seqNo：{}，optionalWireSize：{}，optionalUncompressedSize：{}", seqNo, optionalWireSize, optionalUncompressedSize);
        super.outboundMessageSent(seqNo, optionalWireSize, optionalUncompressedSize);
    }


    /**
     * 接受到服务端响应头
     */
    @Override
    public void inboundHeaders() {
        log.info("用于获得响应头....");
        super.inboundHeaders();
    }

    /**
     * 获得响应消息的编号
     *
     * @param seqNo the sequential number of the message within the stream, starting from 0.  It can
     *              be used to correlate with {@link #inboundMessageRead} for the same message.
     */
    @Override
    public void inboundMessage(int seqNo) {
        log.info("获得响应消息的编号...{} ", seqNo);
        super.inboundMessage(seqNo);
    }

    /**
     * 获得响应消息的大小
     *
     * @param bytes
     */
    @Override
    public void inboundWireSize(long bytes) {
        log.info("获得响应消息的大小...{} ", bytes);
        super.inboundWireSize(bytes);
    }

    /**
     * 获得服务端响应消息
     *
     * @param seqNo                    the sequential number of the message within the stream, starting from 0.  It can
     *                                 be used to correlate with {@link #inboundMessage(int)} for the same message.
     * @param optionalWireSize         the wire size of the message. -1 if unknown
     * @param optionalUncompressedSize the uncompressed serialized size of the message. -1 if unknown
     */
    @Override
    public void inboundMessageRead(int seqNo, long optionalWireSize, long optionalUncompressedSize) {
        log.info("获得消息的编号 {} ，大小 {} ，未压缩大小 {}", seqNo, optionalWireSize, optionalUncompressedSize);
        super.inboundMessageRead(seqNo, optionalWireSize, optionalUncompressedSize);
    }

    /**
     * 获得服务端响应消息未压缩大小
     *
     * @param bytes
     */
    @Override
    public void inboundUncompressedSize(long bytes) {
        log.info("获得响应消息未压缩大小 {} ", bytes);
        super.inboundUncompressedSize(bytes);
    }

    /**
     * 响应结束
     *
     * @param trailers the mutable trailing metadata.  Modifications to it will be seen by
     *                 interceptors and the application.
     */
    @Override
    public void inboundTrailers(Metadata trailers) {
        log.info("响应结束..");
        super.inboundTrailers(trailers);
    }
}
