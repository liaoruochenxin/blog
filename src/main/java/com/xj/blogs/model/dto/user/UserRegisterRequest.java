package com.xj.blogs.model.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "用户登录请求体")
public class UserRegisterRequest {
    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    @Size(min = 4, message = "账号长度不能小于4位")
    @Schema(description = "用户账号")
    private String userAccount;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Size(min = 8, message = "密码长度不能小于8位")
    @Schema(description = "用户密码")
    private String userPassword;

    /**
     * 确认密码
     */
    @NotBlank(message = "确认密码不能为空")
    @Size(min = 8, message = "确认密码长度不能小于8位")
    @Schema(description = "确认密码")
    private String checkPassword;
}

