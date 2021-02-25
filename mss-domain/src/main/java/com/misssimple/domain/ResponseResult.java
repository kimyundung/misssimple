package com.misssimple.domain;

import lombok.Data;

/**
 * 封装响应数据类
 */
@Data
public class ResponseResult {
    private Object data;
    private Object meta;
}
