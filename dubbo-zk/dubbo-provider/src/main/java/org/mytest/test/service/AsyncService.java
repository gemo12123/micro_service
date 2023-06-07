package org.mytest.test.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.AsyncContext;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;

/**
 * @author gemo
 * @date 2023/6/7 19:59
 **/
@Slf4j
@DubboService(timeout = 3000)
public class AsyncService implements IAsyncService{

    /**
     * 在dubbo线程中执行
     *
     * @param i
     * @return
     */
    @Override
    public String invoke(Integer i) {
        // 注意超时
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String s = "Async invoke:" + i;
        log.info(s);
        return s;
    }

    /**
     * 在非dubbo线程中执行
     *
     * @param i
     * @return
     */
    @Override
    public CompletableFuture<String> asyncInvoke(Integer i) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String s = "Async invoke:" + i;
            log.info(s);
            return s;
        });
    }

    @Override
    public String asyncInvoke2(Integer i) {
        final AsyncContext asyncContext = RpcContext.startAsync();
        new Thread(()->{
            // 如果要使用上下文，则必须要放在第一句执行
            asyncContext.signalContextSwitch();
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String s = "Async invoke:" + i;
            log.info(s);
            asyncContext.write(s);
        }).start();
        return null;
    }
}
