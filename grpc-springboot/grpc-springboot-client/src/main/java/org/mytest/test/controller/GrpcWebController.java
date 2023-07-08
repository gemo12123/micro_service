package org.mytest.test.controller;

import com.google.protobuf.InvalidProtocolBufferException;
import org.mytest.test.service.GrpcWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gemo
 * @date 2023/7/8 21:40
 */
@RestController
@RequestMapping("/grpc")
public class GrpcWebController {
    @Autowired
    private GrpcWebService grpcWebService;

    @GetMapping("/simple")
    public String hello() throws InvalidProtocolBufferException {
        return grpcWebService.blockingExecute();
    }
}
