package com.misssimple.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接收商品分类参数类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVo {
    private Integer type;       // 分类层级
    private Integer pagenum;    // 当前页
    private Integer pagesize;   // 每页显示条数
}
