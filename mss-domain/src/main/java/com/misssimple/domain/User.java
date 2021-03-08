package com.misssimple.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 */
@Data
@ToString
public class User implements Serializable {
    private Integer id;         // 用户id
    private String name;        // 用户昵称
    private String portrait;    // 用户头像地址
    private String phone;       // 注册手机
    private String password;    // 用户密码（可以为空，支持只用验证码注册、登录）
    private String regIp;      // 注册ip
    private Integer accountNonLocked;   // 是否未锁定
    private Integer status;      // 户状态：ENABLE能登录，DISABLE不能登录
    private Integer isDel;     // 是否删除
    private Date createTime;    // 注册时间
    private Date updateTime;    // 记录更新时间
}
