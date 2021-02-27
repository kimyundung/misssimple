package com.misssimple.service;

import com.github.pagehelper.PageInfo;
import com.misssimple.domain.User;
import com.misssimple.domain.UserVo;

import java.util.List;

/**
 * 用户service接口
 */
public interface UserService {
    // 分页条件查询用户
    public Object findUserByConditionAndPage(UserVo userVo);
    // 更新用户状态
    public void updateUserStatus(Integer id, Integer status);
    // 添加用户
    public void saveUser(User user) throws Exception;
    // 更新用户
    public void updateUser(User user) throws Exception;
    // 删除用户
    public void deleteUser(Integer id);
    // 用户登录
    public User login(UserVo userVo) throws Exception;
}
