package org.mytest.test.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.mytest.test.entity.ResEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SellService {
    @DubboReference
    private IStoreService storeService;

    public boolean sell(Integer productId, Integer num) {
        log.info("销售商品{}", productId);
        ResEntity storeResult = storeService.sell(productId, num);
        if (storeResult.getResult() == ResEntity.Result.ERROR) {
            log.warn("dubbo 服务调用返回失败，原因：{}", storeResult.getReason());
            return false;
        }
        return true;
    }
}
