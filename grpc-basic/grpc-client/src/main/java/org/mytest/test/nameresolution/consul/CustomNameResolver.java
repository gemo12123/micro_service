package org.mytest.test.nameresolution.consul;

import com.orbitz.consul.Consul;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.model.ConsulResponse;
import com.orbitz.consul.model.health.ServiceHealth;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import io.grpc.Status;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author gemo
 * @date 2023/7/10 21:08
 */
@Slf4j
public class CustomNameResolver extends NameResolver {
    //getServiceAuthority   shutdown

    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);

    private Consul consul;
    private String authority;
    private Listener2 listener;

    /**
     * 用于为authority赋值
     *
     * @param authority
     */
    public CustomNameResolver(String authority) {
        this.authority = authority;
        consul = Consul.builder()
                .build();
    }

    /**
     * authority 概念 服务器集群的名字 grpc-server
     */
    @Override
    public String getServiceAuthority() {
        return this.authority;
    }

    /**
     * listener 中文 叫做监听
     * start方法中我们要周期的发起对于名字解析的请求，获取最新的服务列表
     *
     * @param listener used to receive updates on the target
     */
    @Override
    public void start(Listener2 listener) {
        this.listener = listener;
        scheduledThreadPoolExecutor.scheduleAtFixedRate(this::resolve, 10, 10, TimeUnit.SECONDS);
    }

    /**
     * 定期完成的工作 就是在resolve中处理的
     * 完成解析的工作
     */
    private void resolve() {
        log.info("开始解析服务.... {} ", this.authority);
        //1  获取所有的健康服务 grpc-server
        //把所有的健康服务的 ip+port封装 InetSocketAddress
        List<InetSocketAddress> addressList = getAddressList(this.authority);

        if (addressList == null || addressList.size() == 0) {
            log.info("解析 {} 存在问题失败.....", this.authority);
            this.listener.onError(Status.UNAVAILABLE.withDescription("没有可用的节点...."));
            return;
        }

        //2 负载均衡 gprc 把所健康服务 封装 EquivalentAddressGroup {address:port}
        // InetSocketAddress ---> EquivalentAddressGroup
        List<EquivalentAddressGroup> equivalentAddressGroups = addressList.stream()
                .map(EquivalentAddressGroup::new)
                .collect(Collectors.toList());

        //3 命名解析完成 ResultionResult
        ResolutionResult resolutionResult = ResolutionResult.newBuilder()
                .setAddresses(equivalentAddressGroups)
                .build();

        //监听名字解析的结果
        this.listener.onResult(resolutionResult);
    }

    private List<InetSocketAddress> getAddressList(String authority) {
        HealthClient healthClient = consul.healthClient();
        ConsulResponse<List<ServiceHealth>> response = healthClient.getHealthyServiceInstances(authority);

        List<ServiceHealth> healthList = response.getResponse();

        return healthList.stream()
                .map(ServiceHealth::getService)
                .map(service -> new InetSocketAddress(service.getAddress(), service.getPort()))
                .collect(Collectors.toList());
    }

    @Override
    public void shutdown() {
        scheduledThreadPoolExecutor.shutdown();
    }

    @Override
    public void refresh() {
        super.refresh();
    }

    public static void main(String[] args) {
        HealthClient healthClient = Consul.builder()
                .build().healthClient();
        ConsulResponse<List<ServiceHealth>> response = healthClient.getHealthyServiceInstances("consul:///gRpc-service");
        List<ServiceHealth> healthList = response.getResponse();
        System.out.println(healthList);
    }
}
