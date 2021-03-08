package com.misssimple.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.misssimple.domain.Test;
import com.misssimple.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    //@Autowired
    @Reference
    private TestService testService;

    @RequestMapping("/findAllTest")
    public List<Test> findAllTest(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>testService:"+testService);
        List<Test> testList = testService.findAllTest();
        return testList;
    }
}
