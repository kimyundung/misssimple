package com.misssimple.mapper;

import com.misssimple.domain.User;

import java.util.List;

/**
 * 用户mapper接口
 */
public interface UserMapper {
    // 分页条件查询用户
    public List<User> findUserByConditionAndPage();
}
