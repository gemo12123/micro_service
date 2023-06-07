package org.mytest.test.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.mytest.test.entity.ResEntity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@DubboService
public class StoreService implements IStoreService {
    public static Map<Integer, Integer> STORE = new ConcurrentHashMap<>();

    static {
        STORE.put(1, 10);
        STORE.put(2, 1);
        STORE.put(3, 6);
    }

    @Override
    public ResEntity sell(Integer productId, Integer num) {
        if (!STORE.containsKey(productId)) {
            log.warn("商品{}不存在！", productId);
            return new ResEntity(ResEntity.Result.ERROR, "商品不存在！");
        }
        synchronized (StoreService.class) {
            Integer productNum = STORE.get(productId);
            if (productNum >= num) {
                STORE.put(productId, productNum - num);
                log.info("仓储扣减{}号商品{}件！", productId, num);
                return new ResEntity(ResEntity.Result.SUCCESS);
            }
            log.warn("尝试扣减{}号商品{}件失败，存储剩余{}件！", productId, num, productNum);
        }
        return new ResEntity(ResEntity.Result.ERROR, "库存不足！");
    }
}
