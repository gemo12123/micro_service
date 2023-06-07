package org.mytest.test.service;

import java.util.concurrent.CompletableFuture;

/**
 * @author gemo
 * @date 2023/6/7 19:58
 **/
public interface IAsyncService {
    String invoke(Integer i);

    CompletableFuture<String> asyncInvoke(Integer i);
    String asyncInvoke2(Integer i);
}
