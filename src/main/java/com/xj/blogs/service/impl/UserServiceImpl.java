package com.xj.blogs.service.impl;

import org.springframework.stereotype.Service;

import com.xj.blogs.constant.UserConstant;
import com.xj.blogs.exception.BusinessException;
import com.xj.blogs.exception.ErrorCode;
import com.xj.blogs.exception.ThrowUtils;
import com.xj.blogs.handle.UserHandle;
import com.xj.blogs.helper.UserHelper;
import com.xj.blogs.model.entity.User;
import com.xj.blogs.model.enums.UserRoleEnum;
import com.xj.blogs.model.vo.UserLoginVO;
import com.xj.blogs.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserHandle userHandle;

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        // 检查两次输入密码是否一致
        ThrowUtils.throwIf(!userPassword.equals(checkPassword), 
            new BusinessException(ErrorCode.PARAMS_ERROR, "两次输入密码不一致"));

        // 检查账号是否已存在
        long count = userHandle.countByAccount(userAccount);
        ThrowUtils.throwIf(count > 0, new BusinessException(ErrorCode.PARAMS_ERROR, "账号已存在"));

        // 密码加密
        String encryptPassword = UserHelper.getEncryptPassword(userPassword);
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
        user.setUserRole(UserRoleEnum.USER.getValue());
        user.setUserName("username");
        userHandle.insert(user);
        return user.getId();
    }

    @Override
    public UserLoginVO userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        String encryptPassword = UserHelper.getEncryptPassword(userPassword);
        User user = userHandle.queryByUserAccount(userAccount);
        ThrowUtils.throwIf(user == null, new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在"));
        ThrowUtils.throwIf(!user.getUserPassword().equals(encryptPassword), 
            new BusinessException(ErrorCode.PARAMS_ERROR, "密码错误"));
        
        // 记录用户登录态
        request.getSession().setAttribute(UserConstant.USER_LOGIN_STATE, user);
        return UserHelper.copy2UserLoginVO(user);
    }

    @Override
    public UserLoginVO getLoginUser(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE);
        if (userObj instanceof User user) {
            ThrowUtils.throwIf(user.getId() == null, new BusinessException(ErrorCode.NOT_LOGIN_ERROR));
            return UserHelper.copy2UserLoginVO(user);
        }
        throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR); 
    }
}
