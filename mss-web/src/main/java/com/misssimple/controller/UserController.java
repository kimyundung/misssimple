package com.misssimple.controller;

import com.github.pagehelper.PageInfo;
import com.misssimple.domain.Meta;
import com.misssimple.domain.ResponseResult;
import com.misssimple.domain.User;
import com.misssimple.domain.UserVo;
import com.misssimple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 分页条件查询用户
    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVo userVo){
        System.out.println(">>>>>>>>>>>>>>>"+userVo);
        // 1.调用service方法
        Object object = userService.findUserByConditionAndPage(userVo);
        // 2.数据
        ResponseResult result = new ResponseResult();
        result.setData(object);
        result.setMeta(new Meta(200,"成功查询用户"));
        return result;
    }

    // 更新用户状态
    @RequestMapping("/updateUserStatus")
    public ResponseResult updateUserStatus(Integer id, Integer status){
        // 1.调用service方法
        userService.updateUserStatus(id,status);
        // 2.响应数据
        ResponseResult result = new ResponseResult();
        Map<String, Integer> map = new HashMap<>();
        map.put("status",status);
        result.setData(map);
        result.setMeta(new Meta(202,"更新用户状态成功"));
        return result;
    }

    // 添加用户
    @RequestMapping("/saveUser")
    public ResponseResult saveUser(@RequestBody User user) throws Exception {
        userService.saveUser(user);
        ResponseResult result = new ResponseResult();
        result.setData(null);
        result.setMeta(new Meta(201,"成功添加用户"));
        return result;
    }

    // 更新用户
    @RequestMapping("/updateUser")
    public ResponseResult updateUser(@RequestBody User user) throws Exception {
        userService.updateUser(user);
        ResponseResult result = new ResponseResult();
        result.setData(null);
        result.setMeta(new Meta(202,"更新用户成功"));
        return  result;
    }

    // 删除用户
    @RequestMapping("/deleteUser")
    public ResponseResult deleteUser(Integer id){
        userService.deleteUser(id);
        ResponseResult result = new ResponseResult();
        result.setMeta(new Meta(203,"删除用户成功"));
        return result;
    }

    // 用户登录
    @RequestMapping("/login")
    public ResponseResult login(@RequestBody UserVo userVo) throws Exception {
        User user = userService.login(userVo);
        ResponseResult result = new ResponseResult();
        result.setData(user);
        if(user!=null){
            result.setMeta(new Meta(200, "登录成功"));
        } else {
            result.setMeta(new Meta(500,"用户名或密码错误"));
        }
        return result;
    }
}
