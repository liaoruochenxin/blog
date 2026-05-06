package com.xj.blogs.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegisterRequest {
    /**
     * 账号
     */
    @NotEmpty(message = "账号不能为空")
    @Size(min = 4, message = "账号长度不能小于4位")
    private String userAccount;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    @Size(min = 8, message = "密码长度不能小于8位")
    private String userPassword;

    /**
     * 确认密码
     */
    @NotEmpty(message = "确认密码不能为空")
    @Size(min = 8, message = "确认密码长度不能小于8位")
    private String checkPassword;
}

