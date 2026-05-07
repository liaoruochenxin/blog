package com.xj.blogs.model.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "用户登录请求体")
public class UserLoginRequest {

    @Schema(description = "账号")
    @NotBlank(message = "用户账号不能为空")
    private String userAccount;

    @Schema(description = "用户密码")
    @NotBlank(message = "用户密码不能为空")
    private String userPassword;
}

