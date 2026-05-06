package com.xj.blogs.common;

import com.xj.blogs.exception.ErrorCode;

public class ResultUtils {

    /**
     * 成功响应
     * @param <T> 数据类型
     * @param data 业务数据
     * @return 响应
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * 失败响应
     * @param errorCode 错误码枚举
     * @return 响应
     */
    public static BaseResponse<Void> error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    /**
     * 失败响应
     * @param code 错误码
     * @param message 错误信息
     * @return 响应
     */
    public static BaseResponse<Void> error(int code, String message) {
        return new BaseResponse<>(code, null, message);
    }

    /**
     * 失败响应
     * @param errorCode 错误码枚举
     * @param message 错误信息
     * @return 响应
     */
    public static BaseResponse<Void> error(ErrorCode errorCode, String message) {
        return new BaseResponse<>(errorCode.getCode(), null, message);
    }
}
