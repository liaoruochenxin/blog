package com.xj.blogs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xj.blogs.common.BaseResponse;
import com.xj.blogs.common.ResultUtils;

@RestController
@RequestMapping("/")
public class MainController {

    /**
     * 健康检查
     * @return
     */
    @GetMapping("/health")
    public BaseResponse<String> health() {
        return ResultUtils.success("ok");
    }
}
