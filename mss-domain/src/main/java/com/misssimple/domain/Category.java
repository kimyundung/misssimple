package com.misssimple.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 商品分类表
 */
@Data
public class Category {
    /*
    cat_id 	    INT(11) 	UNSIGNED NOT NULL AUTO_INCREMENT 	COMMENT '分类唯一ID',
    cat_name 	VARCHAR(32) 	UNIQUE   NOT NULL 			COMMENT '分类名称',
    cat_pid 	INT(11) 	UNSIGNED DEFAULT NULL 			COMMENT '分类父ID',
    cat_level 	INT(4) 		DEFAULT NULL 				COMMENT '分类层级 0: 顶级 1:二级',
    cat_icon 	VARCHAR(255) 	DEFAULT NULL 				COMMENT '?',
    cat_src 	TEXT 							COMMENT '指向外部资源的位置',
    is_del 	    TINYINT(1) 	DEFAULT '0' 				COMMENT '0:正常  1:删除',
    create_time 	DATETIME 	NOT NULL 				COMMENT '记录生成时间',
    update_time 	DATETIME 	NOT NULL 				COMMENT '记录修改时间',
    delete_time 	DATETIME 	DEFAULT NULL 				COMMENT '删除时间标志',
    created_by 	VARCHAR(100) 	NOT NULL 				COMMENT '创建人',
    updated_by 	VARCHAR(100) 	NOT NULL 				COMMENT '更新人',
    deleted_by 	VARCHAR(100) 	DEFAULT NULL 				COMMENT '删除人',*/
    private Integer catId;      // 分类唯一ID
    private String catName;     // 分类名称
    private Integer catPid;     // 分类父ID
    private Integer catLevel;   // 分类层级 0:顶级 1:二级
    private String catIcon;     // ?
    private String catSrc;      // ?
    private Integer isDel;      // 是否删除
    private Date createTime;    // 记录生成时间
    private Date updateTime;    // 记录修改时间
    private Date deleteTime;    // 删除时间标志
    private String createdBy;   // 创建人
    private String updatedBy;   // 更新人
    private String deletedBy;   // 删除人

    // 一级分类下的二级商品分类
    private List<Category> categoryList;
}
