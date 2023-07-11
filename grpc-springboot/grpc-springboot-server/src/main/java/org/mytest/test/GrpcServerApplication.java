package org.mytest.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gemo
 * @date 2023/7/8 21:16
 */
//@EnableDiscoveryClient
@SpringBootApplication
public class GrpcServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrpcServerApplication.class,args);
    }
}
