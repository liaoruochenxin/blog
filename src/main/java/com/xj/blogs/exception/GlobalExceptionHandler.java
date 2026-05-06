package com.xj.blogs.exception;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.xj.blogs.common.BaseResponse;
import com.xj.blogs.common.ResultUtils;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse<Void> businessExceptionHandler(BusinessException businessException) {
        log.warn("businessException ", businessException);
        return ResultUtils.error(businessException.getCode(), businessException.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) 
    public BaseResponse<Void> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        String message = fieldError != null ? fieldError.getDefaultMessage() : "请求参数错误";
        log.warn("methodArgumentNotValidException: {}", message);
        return ResultUtils.error(ErrorCode.PARAMS_ERROR, message);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public BaseResponse<Void> methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e) {
        String message = String.format("参数类型不匹配: %s", e.getName());
        log.warn("methodArgumentTypeMismatchException: {}", message);
        return ResultUtils.error(ErrorCode.PARAMS_ERROR, message);
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<Void> runtimeExceptionHandler(RuntimeException runtimeException) {
        log.error("RuntimeException", runtimeException);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "系统错误");
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse<Void> exceptionHandle(Exception e) {
        log.error("系统异常", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "系统内部错误");
    }
}
