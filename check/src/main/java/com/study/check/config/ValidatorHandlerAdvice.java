package com.study.check.config;

import com.alibaba.fastjson.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author luobo
 * @desc validation 校验配置，统一结果处理
 * @since 2021-11-18 10:43
 */
@RestControllerAdvice
public class ValidatorHandlerAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return !returnType.getGenericParameterType().equals(Results.class);
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        // String 或 其它基本数据类型需要额外处理
        if (returnType.getGenericParameterType().equals(String.class)) {
            return JSON.toJSONString(Results.success(body.toString()));
        }

        // 返回统一结果
        return Results.success(body);
    }
}
