package com.xj.blogs.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "登录用户VO")
public class UserLoginVO {

    @Schema(description = "用户账号")
    private String userAccount;

    @Schema(description = "用户头像")
    private String userAvatar;

    @Schema(description = "用户简介")
    private String userProfile;
}
