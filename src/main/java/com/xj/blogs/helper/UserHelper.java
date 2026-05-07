package com.xj.blogs.helper;

import org.springframework.util.DigestUtils;

import com.xj.blogs.model.entity.User;
import com.xj.blogs.model.vo.UserLoginVO;

import cn.hutool.core.bean.BeanUtil;

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

    public static UserLoginVO copy2UserLoginVO(User user) {
        return BeanUtil.copyProperties(user, UserLoginVO.class);
    }
}
