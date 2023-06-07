package org.mytest.test.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.mytest.test.service.IGroupVersionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gemo
 * @date 2023/6/7 21:27
 **/
@RestController
@RequestMapping("/gv")
public class GroupVersionController {
    @DubboReference(group = "group1", version = "1.0")
    private IGroupVersionService gv1;
    @DubboReference(group = "group2", version = "2.0")
    private IGroupVersionService gv2;

    @GetMapping("/groupVersion/{gv}")
    public String run(@PathVariable("gv") String gv) {
        switch (gv) {
            case "1":
                return gv1.invoke();
            case "2":
                return gv2.invoke();
            default:
                return "error gv!";
        }
    }
}
