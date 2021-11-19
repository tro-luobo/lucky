package com.study.check.config;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * @author luobo
 * @desc 统一异常结果处理
 * @since 2021-11-18 11:02
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Controller Bean 入参校验异常结果处理
     *
     * @param e 异常
     * @return result
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Results<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return Results.error(Objects.requireNonNull(e.getBindingResult()
                .getFieldError())
                .getDefaultMessage());
    }

    /**
     * 统一异常结果处理
     *
     * @return result
     */
    @ExceptionHandler(Exception.class)
    public Results<?> handleException(Exception e) {
        return Results.error(e.getMessage());
    }

}
