package com.misssimple.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 商品表
 */
@Data
@NoArgsConstructor
public class Goods {
    /*
    goods_id 	    INT(11) 	    UNSIGNED NOT NULL AUTO_INCREMENT 	COMMENT '主键id',
    goods_name 	    VARCHAR(32) 	NOT NULL 				            COMMENT '商品名称',
    goods_price 	DECIMAL(10,2) 	NOT NULL DEFAULT '0.00' 		    COMMENT '商品价格',
    cat_id 	        INT(11) 	UNSIGNED NOT NULL 			COMMENT '类型id',
    goods_introduce  TEXT 						            COMMENT '商品详情介绍',
    goods_big_logo   CHAR(128) 	NOT NULL DEFAULT '' 	    COMMENT '图片logo大图',
    goods_small_logo CHAR(128) 	NOT NULL DEFAULT '' 		COMMENT '图片logo小图',
    cat_one_id 	    INT(11) 	UNSIGNED NOT NULL 			COMMENT '一级分类id',
    cat_two_id 	    INT(11) 	UNSIGNED NOT NULL 			COMMENT '二级分类id',
    hot_number 	    INT(11) 	UNSIGNED DEFAULT '0' 		COMMENT '热卖数量',
    is_promote      INT(11) 	DEFAULT '0' 				COMMENT '是否促销',
    status 	        INT(11) 	DEFAULT '0' 				COMMENT '商品状态 0下架 1上架',
    is_del 	        TINYINT(1) 	DEFAULT '0' 				COMMENT '0:正常  1:删除',
    create_time 	DATETIME 	NOT NULL 				    COMMENT '记录生成时间',
    update_time 	DATETIME 	NOT NULL 				    COMMENT '记录修改时间',
    delete_time 	DATETIME 	DEFAULT NULL 				COMMENT '删除时间标志',
    created_by 	    VARCHAR(100) 	NOT NULL 				COMMENT '创建人',
    updated_by 	    VARCHAR(100) 	NOT NULL 				COMMENT '更新人',
    deleted_by 	    VARCHAR(100) 	DEFAULT NULL 			COMMENT '删除人',*/
    private Integer goodsId;        // 主键id
    private String goodsName;       // 商品名称
    private Double goodsPrice;      // 商品价格
    private Integer catId;          // 类型id
    private String goodsIntroduce;  // 商品详情介绍
    private String goodsBigLogo;    // 图片logo大图
    private String goodsSmallLogo;  // 图片logo小图

    private Integer catOneId;   // 一级分类id
    private Integer caTwoId;    // 二级分类id
    private Integer hotNumber;  // 热卖数量
    private Integer isPromote;  // 是否促销
    private Integer status;     // 商品状态 0下架 1上架
    private Integer isDel;      // 是否删除
    private Date createTime;    // 记录生成时间
    private Date updateTime;    // 记录修改时间
    private Date deleteTime;    // 删除时间标志
    private String createdBy;   // 创建人
    private String updatedBy;   // 更新人
    private String deletedBy;   // 删除人

    // 该商品拥有的相册集合
    private List<GoodsPics> pics;
}
