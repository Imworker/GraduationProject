package com.alibaba.service.Impl;

import com.alibaba.bean.User;
import com.alibaba.bean.response.Response;
import com.alibaba.mapper.UserMapper;
import com.alibaba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    public Response regist(User user) {
        if (user == null) {
            return Response.failed("注册失败");
        }
        User res = userMapper.findUserByName(user.getUsername());
        if (res != null) {
            return Response.failed("用户名已存在");
        }
        userMapper.regist(user);
        return Response.success("注册成功",user);
    }
    /**
     * 登录
     * @param user 用户名和密码
     * @return Result
     */
    public Response login(User user) {
        if  (user == null) {
            return Response.failed("登录失败");
        }
        User res =  userMapper.login(user);
        if ( res != null) {
            return Response.success("登录成功",res);
        } else {
            return Response.failed("登录失败");
        }
    }
}
