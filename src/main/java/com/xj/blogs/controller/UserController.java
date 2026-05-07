package com.xj.blogs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xj.blogs.common.BaseResponse;
import com.xj.blogs.common.ResultUtils;
import com.xj.blogs.model.dto.user.UserLoginRequest;
import com.xj.blogs.model.dto.user.UserRegisterRequest;
import com.xj.blogs.model.vo.UserLoginVO;
import com.xj.blogs.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody @Validated UserRegisterRequest entity) {
        return ResultUtils.success(userService.userRegister(entity.getUserAccount(), 
            entity.getUserPassword(), 
            entity.getCheckPassword()));  
    }

    @PostMapping("/login")
    public BaseResponse<UserLoginVO> userLogin(@RequestBody @Validated UserLoginRequest entity, HttpServletRequest request) {
        return ResultUtils.success(userService.userLogin(entity.getUserAccount(), entity.getUserPassword(), request));
    }
    
}
