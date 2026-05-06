package com.xj.blogs.helper;

import org.springframework.util.DigestUtils;

public class UserHelper {

    // 盐值
    private static final String SALT = "jiangwei";
    /**
     * 密码加密
     * @param userPassword 原用户密码
     * @return 加密后密码
     */
    public static String getEncryptPassword(String userPassword) {
        return DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
    }
}
