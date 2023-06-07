package org.mytest.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.mytest.test.service.IAsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author gemo
 * @date 2023/6/7 20:01
 **/
@Slf4j
@RequestMapping("/ctl")
@RestController
public class AsyncController {
    @DubboReference
    private IAsyncService asyncService;

    /**
     * 消费者异步调用，没有严格时序上的关系、不是原子操作、不影响逻辑情况下可以使用异步调用
     *
     * @param time
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @GetMapping("/consumer/async/{time}")
    public String async(@PathVariable("time") int time) throws InterruptedException, ExecutionException {
        List<CompletableFuture<String>> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < time; i++) {
            int j = i + 1;
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> asyncService.invoke(j))
                    .whenComplete((result, e) -> {
                        if (e != null) {
                            log.error("async invoke error!", e);
                            return;
                        }
                        builder.append(result);
                    });
            list.add(future);
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(list.toArray(new CompletableFuture<?>[0]));
        allOf.get();
        return builder.toString();
    }

    @GetMapping("/provider/async/{time}")
    public String providerAsync(@PathVariable("time") int time) throws InterruptedException, ExecutionException {
        List<CompletableFuture<String>> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < time; i++) {
            int j = i + 1;
            CompletableFuture<String> future = asyncService.asyncInvoke(j)
                    .whenComplete((result, e) -> {
                        if (e != null) {
                            log.error("async invoke error!", e);
                            return;
                        }
                        builder.append(result);
                    });
            list.add(future);
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(list.toArray(new CompletableFuture<?>[0]));
        allOf.get();
        return builder.toString();
    }
    @GetMapping("/provider/async2/{time}")
    public String providerAsync2(@PathVariable("time") int time) throws InterruptedException, ExecutionException {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < time; i++) {
            int j = i + 1;
            String s = asyncService.asyncInvoke2(j);
            builder.append(s);
        }
        return builder.toString();
    }
}
