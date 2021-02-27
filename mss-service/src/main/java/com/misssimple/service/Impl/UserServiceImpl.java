package com.misssimple.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.misssimple.domain.User;
import com.misssimple.domain.UserVo;
import com.misssimple.mapper.UserMapper;
import com.misssimple.service.UserService;
import com.misssimple.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户service接口实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Object findUserByConditionAndPage(UserVo userVo) {
        if(userVo.getPagenum()!=null && userVo.getPagesize()!=null){
            PageHelper.startPage(userVo.getPagenum(),userVo.getPagesize());
            List<User> userList = userMapper.findUserByCondition(userVo);
            PageInfo<User> pageInfo = new PageInfo<>(userList);
            return pageInfo;
        } else {
            List<User> userList = userMapper.findUserByCondition(userVo);
            return userList;
        }
    }

    // 更新用户状态
    @Override
    public void updateUserStatus(Integer id, Integer status) {
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        user.setUpdateTime(new Date());
        userMapper.updateUserStatus(user);
    }

    // 添加用户
    @Override
    public void saveUser(User user) throws Exception {
        user.setPassword(Md5.md5(user.getPassword(),"StOne"));
        Date date = new Date();
        user.setCreateTime(date);
        user.setUpdateTime(date);
        userMapper.saveUser(user);
    }

    // 更新用户
    @Override
    public void updateUser(User user) throws Exception {
        user.setPassword(Md5.md5(user.getPassword(),"StOne"));
        user.setUpdateTime(new Date());
        userMapper.updateUser(user);
    }

    // 删除用户
    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }

    // 用户登录
    @Override
    public User login(UserVo userVo) throws Exception {
        User user = userMapper.login(userVo.getUsername());
        if(user!=null && Md5.verify(userVo.getPassword(), "StOne", user.getPassword())){
            return user;
        } else {
            return null;
        }
    }

}
