package com.misssimple.domain;

import lombok.Data;

import java.util.Date;

/**
 * 用户表
 */
@Data
public class User {
    /*
    `id` 		  INT(11)       NOT NULL AUTO_INCREMENT 	COMMENT '用户id',
    `name` 	      VARCHAR(255)  NOT NULL 			COMMENT '用户昵称',
    `portrait` 	  VARCHAR(255)  DEFAULT NULL 		COMMENT '用户头像地址',
    `phone` 	  VARCHAR(255)  NOT NULL 			COMMENT '注册手机',
    `password` 	  VARCHAR(255)  DEFAULT NULL 		COMMENT '用户密码（可以为空，支持只用验证码注册、登录）',
    `reg_ip` 	  VARCHAR(255)  DEFAULT NULL 		COMMENT '注册ip',
    `account_non_locked` BIT(1) DEFAULT b'1' 		COMMENT '是否未锁定',
    `status` 	  VARCHAR(20)   NOT NULL DEFAULT 'ENABLE' COMMENT '用户状态：ENABLE能登录，DISABLE不能登录',
    `is_del` 	  BIT(1)        NOT NULL DEFAULT b'0' 	COMMENT '是否删除',
    `create_time` DATETIME      NOT NULL 			COMMENT '注册时间',
    `update_time` DATETIME      NOT NULL 			COMMENT '记录更新时间',*/
    private Integer id;         // 用户id
    private String name;        // 用户昵称
    private String portrait;    // 用户头像地址
    private String phone;       // 注册手机
    private String password;    // 用户密码（可以为空，支持只用验证码注册、登录）
    private String reg_ip;      // 注册ip
    private Integer accountNonLocked;   // 是否未锁定
    private String status;      // 户状态：ENABLE能登录，DISABLE不能登录
    private Integer is_del;     // 是否删除
    private Date createTime;    // 注册时间
    private Date updateTime;    // 记录更新时间
}
