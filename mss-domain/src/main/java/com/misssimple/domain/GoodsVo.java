package com.misssimple.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 接收商品查询参数的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GoodsVo {

    private Integer goodsId;

    private Double goodsPrice;      // 商品价格
    private List<Integer> catIds;   // 商品属于的父子分类
    private String goodsIntroduce;  // 商品描述
    private List<PicVo> pics;  // 商品图片

    private String goodsName;   // 商品名称
    private Integer status;     // 上架,下架,全部
    private Integer catId;      // 分类id
    private Integer pagenum;    // 当前页
    private Integer pagesize;   // 每页显示条数
}
