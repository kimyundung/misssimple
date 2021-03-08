package com.misssimple.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.misssimple.domain.Test;
import com.misssimple.mapper.TestMapper;
import com.misssimple.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findAllTest() {
        return testMapper.findAllTest();
    }
}
