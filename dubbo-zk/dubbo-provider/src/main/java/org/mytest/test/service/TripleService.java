package org.mytest.test.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.mytest.test.entity.proto.Request;
import org.mytest.test.entity.proto.Response;

/**
 * @author gemo
 * @date 2023/6/29 21:13
 */
@Slf4j
@DubboService
public class TripleService implements ITripleService{
    @Override
    public Response printRequest(Request request) {
        log.info("{}",request);
        return Response.newBuilder()
                .setResult(request.getParam().startsWith("triple"))
                .build();
    }

    @Override
    public void requestProto(Request request) {
        String param = request.getParam();
        log.info("requestProto:{}",param);
    }

    @Override
    public Response responeProto() {
        log.info("responeProto");
        return Response.newBuilder()
                .setResult(true)
                .build();
    }

    @Override
    public void noneProto() {
        log.info("noneProto");
    }

    @Override
    public boolean basicParam(String s) {
        log.info("basicParam:{}",s);
        return s.startsWith("triple");
    }
}
