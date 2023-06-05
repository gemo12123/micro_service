package org.mytest.test.service;

import org.mytest.test.entity.ResEntity;

public interface IStoreService {
    /**
     * 出售商品
     * @param productId 商品id
     * @param num 出售数量
     * @return
     */
    ResEntity sell(Integer productId,Integer num);
}
