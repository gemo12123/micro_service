package org.mytest.test.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.mytest.test.entity.proto.Request;
import org.mytest.test.entity.proto.Response;
import org.mytest.test.service.ITripleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gemo
 * @date 2023/6/29 21:15
 */
@RequestMapping("/triple")
@RestController
public class TripleController {
    @DubboReference
    private ITripleService tripleService;

    @GetMapping("/test/{s}")
    public String test(@PathVariable("s") String s){
        Request request = Request.newBuilder()
                .setParam(s)
                .build();
        Response response = tripleService.printRequest(request);
        boolean result = response.getResult();
        return "结果："+result;
    }

    @GetMapping("/request/{s}")
    public String request(@PathVariable("s") String s){
        Request request = Request.newBuilder()
                .setParam(s)
                .build();
        tripleService.requestProto(request);
        return "request end!";
    }

    @GetMapping("/response")
    public String response(){
        Response response = tripleService.responeProto();
        boolean result = response.getResult();
        return "request end! "+result;
    }

    @GetMapping("/none")
    public String none(){
        tripleService.noneProto();
        return "none end!";
    }

    @GetMapping("/basic/{s}")
    public String basic(@PathVariable("s") String s){
        boolean result = tripleService.basicParam(s);
        return "basic:"+result;
    }

}
