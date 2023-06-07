package org.mytest.test.service;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author gemo
 * @date 2023/6/7 21:24
 **/
@DubboService(group = "group2",version = "2.0")
public class GroupVersionService02 implements IGroupVersionService {
    @Override
    public String invoke() {
        return "this is group2, version 2.0";
    }
}
