package org.mytest.test.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

import java.util.Map;

/**
 * @author gemo
 * @date 2023/6/7 21:42
 **/
@Slf4j
@DubboService
public class ContextService implements IContextService{
    @Override
    public String invoke(String param) {
        //ServerAttachment接收客户端传递过来的参数
        Map<String, Object> serverAttachments = RpcContext.getServerAttachment().getObjectAttachments();
        log.info("attachment: {}" , serverAttachments);
        //往客户端传递参数
        // 可传入
        RpcContext.getServerContext().setAttachment("serverKey","serverValue");
        // 无法传入
        RpcContext.getClientAttachment().setAttachment("serverKey2","serverValue2");
        return param;
    }
}
