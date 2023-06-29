package org.mytest.test.service;

import org.mytest.test.entity.proto.Request;
import org.mytest.test.entity.proto.Response;

/**
 * 注意：需要将dubbo.protocol.name置为tri
 *
 * @author gemo
 * @date 2023/6/29 21:12
 */
public interface ITripleService {
    /**
     * 请求相应全部为protobuf格式
     * @param request
     * @return
     */
    Response printRequest(Request request);

    /**
     * 参数部分为protobuf格式
     * 调用失败，consumer报错：method params error method=requestProto
     * @param request
     */
    void requestProto(Request request);

    /**
     * 响应部分为protobuf格式
     * 调用失败，consumer报错：ArrayIndexOutOfBoundsException: 0
     * @return
     */
    Response responeProto();

    /**
     * 无protobuf
     * 无报错，可正常调用
     */
    void noneProto();

    /**
     * 非proto参数
     * 无报错，可正常调用
     * @param s
     * @return
     */
    boolean basicParam(String s);
}
