package com.alibaba.service;

import com.alibaba.bean.User;
import com.alibaba.bean.response.Response;

public interface UserService {
    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    Response regist(User user);
    /**
     * 登录
     * @param user 用户名和密码
     * @return Result
     */
    Response login(User user);
}
