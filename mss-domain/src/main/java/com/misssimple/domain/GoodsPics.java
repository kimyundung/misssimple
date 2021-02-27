package com.misssimple.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 商品相册表
 */
@Data
public class GoodsPics {
    /*
    pics_id 	INT(11) 	UNSIGNED NOT NULL AUTO_INCREMENT 	COMMENT '主键id',
    goods_id 	INT(11) 	UNSIGNED NOT NULL 			        COMMENT '商品id',
    pics_big 	CHAR(128) 	NOT NULL DEFAULT '' 			COMMENT '相册大图800*800',
    pics_mid 	CHAR(128) 	NOT NULL DEFAULT '' 			COMMENT '相册中图350*350',
    pics_sma 	CHAR(128) 	NOT NULL DEFAULT '' 			COMMENT '相册小图50*50',
    is_del 	TINYINT(1) 	DEFAULT '0' 				        COMMENT '0:正常  1:删除',
    create_time 	DATETIME 	NOT NULL 				    COMMENT '记录生成时间',
    update_time 	DATETIME 	NOT NULL 				    COMMENT '记录修改时间',
    delete_time 	DATETIME 	DEFAULT NULL 				COMMENT '删除时间标志',
    created_by 	VARCHAR(100) 	NOT NULL 				    COMMENT '创建人',
    updated_by 	VARCHAR(100) 	NOT NULL 				    COMMENT '更新人',
    deleted_by 	VARCHAR(100) 	DEFAULT NULL 				COMMENT '删除人',*/
    private Integer picsId;    // 主键id
    private Integer goodsId;   // 商品id
    private String picsBig;    // 相册大图800*800
    private String picsMid;    // 相册中图350*350
    private String picsSma;    // 相册小图50*50
    private Integer isDel;     // 0:正常  1:删除
    private Date createTime;   // 记录生成时间
    private Date updateTime;   // 记录修改时间
    private Date deleteTime;   // 删除时间标志
    private String createdBy;  // 创建人
    private String updatedBy;  // 更新人
    private String deletedBy;  // 删除人
}
