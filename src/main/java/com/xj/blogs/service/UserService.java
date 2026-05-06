package com.xj.blogs.service;

public interface UserService {

    /**
     * 用户注册
     * @param userAccount 用户账号
     * @param userPassword 用户密码 
     * @param checkPassword 确认密码
     * @return 用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);
}
