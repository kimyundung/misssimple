package com.misssimple.mapper;

import com.misssimple.domain.User;
import com.misssimple.domain.UserVo;

import java.util.List;

/**
 * 用户mapper接口
 */
public interface UserMapper {
    // 条件查询用户
    public List<User> findUserByCondition(UserVo userVo);
    // 更新用户状态
    public void updateUserStatus(User user);
    // 添加用户
    public void saveUser(User user);
    // 更新用户
    public void updateUser(User user);
    // 删除用户
    public void deleteUser(Integer id);
    // 用户登陆
    public User login(String username);

}
