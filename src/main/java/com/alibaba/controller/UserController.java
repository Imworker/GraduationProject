package com.alibaba.controller;

import com.alibaba.bean.User;
import com.alibaba.bean.response.Response;
import com.alibaba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicinalPSS")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    @PostMapping(value = "/regist")
    public Response regist(@RequestBody User user){
        return userServiceImpl.regist(user);
    }

    /**
     * 登录
     * @param user 参数封装
     * @return Result
     */
    @PostMapping(value = "/login")
    public Response login(@RequestBody  User user){
        return userServiceImpl.login(user);
    }
}

