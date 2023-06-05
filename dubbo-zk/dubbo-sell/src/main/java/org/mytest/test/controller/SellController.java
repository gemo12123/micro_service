package org.mytest.test.controller;

import org.mytest.test.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellController {
    @Autowired
    private SellService sellService;

    @GetMapping("/sell")
    public String sell(Integer productId, Integer num){
        if(productId==null||num==null||num<=0){
            return "Param is error!";
        }
        boolean result = sellService.sell(productId, num);
        return result?"销售成功！":"销售失败！！";
    }
}
