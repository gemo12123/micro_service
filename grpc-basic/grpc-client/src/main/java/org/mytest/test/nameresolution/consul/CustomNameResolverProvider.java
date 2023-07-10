package org.mytest.test.nameresolution.consul;

import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;

import java.net.URI;

/**
 * @author gemo
 * @date 2023/7/10 21:12
 */
public class CustomNameResolverProvider extends NameResolverProvider {
    /**
     * 作用：告知Grpc 自定义的ResolverProvider生效
     *
     * @return
     */
    @Override
    protected boolean isAvailable() {
        return true;
    }

    /**
     * 优先级应该高于DNS（5）命名服务
     *
     * @return
     */
    @Override
    protected int priority() {
        return 6;
    }

    @Override
    public NameResolver newNameResolver(URI targetUri, NameResolver.Args args) {
        return new CustomNameResolver(targetUri.toString());
    }

    /**
     * 名字解析 （注册中心）通信的协议 consul
     *
     * @return
     */
    @Override
    public String getDefaultScheme() {
        return "consul";
    }
}
