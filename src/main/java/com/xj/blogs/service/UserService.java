package com.xj.blogs.service;

import com.xj.blogs.model.vo.UserLoginVO;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

    /**
     * 用户注册
     * @param userAccount 用户账号
     * @param userPassword 用户密码 
     * @param checkPassword 确认密码
     * @return 用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     * @param userAccount 账号
     * @param userPassword 密码
     * @param request 
     * @return 脱敏后用户信息
     */
    UserLoginVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取当前登录用户
     * @param request
     * @return 
     */
    UserLoginVO getLoginUser(HttpServletRequest request);

    /**
     * 用户注销
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest request);
}
