package org.mytest.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.mytest.test.service.IContextService;
import org.mytest.test.service.IGroupVersionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author gemo
 * @date 2023/6/7 21:38
 **/
@Slf4j
@RestController
@RequestMapping("/context")
public class ContextController {
    @DubboReference
    private IContextService contextService;

    @GetMapping("/context")
    public String run(){
        //往服务端传递参数
        // 可传入provider
        RpcContext.getClientAttachment().setAttachment("clientKey1","clientValue1");
        // 不可传入provider
        RpcContext.getServerContext().setAttachment("clientKey2","clientValue2");
        String test = contextService.invoke("test");
        Map<String, Object> clientAttachment = RpcContext.getServerContext().getObjectAttachments();
        log.info("attachment:{}", clientAttachment);
        return test;
    }
}
