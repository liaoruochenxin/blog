package com.xj.blogs.common;

import com.xj.blogs.exception.ErrorCode;

import lombok.Data;

@Data
public class BaseResponse<T> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 状态信息
     */
    private String message;

    /**
     * 业务数据
     */
    private T data;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(int code, T data) {
        this(code, data, "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null,errorCode.getMessage());
    }
}
