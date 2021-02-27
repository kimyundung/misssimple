package com.misssimple.service.Impl;

import com.misssimple.mapper.PhotoMapper;
import com.misssimple.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoMapper photoMapper;
}
