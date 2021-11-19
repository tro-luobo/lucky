package com.study.check.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luobo
 * @desc 异常统一返回对象
 * @since 2021-11-18 10:54
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Results<T> implements Serializable {

    /**
     * 请求返回码
     */
    private Integer code;

    /**
     * 请求返回信息
     */
    private String message;

    /**
     * 请求是否成功
     */
    private Boolean success;

    /**
     * 请求返回数据
     */
    private T data;

    /**
     * 当前时间戳
     */
    private Long timestamp = System.currentTimeMillis();

    public Results(Integer code, String message, Boolean success, T data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    /**
     * 正常结果返回
     *
     * @param data 返回数据
     * @param <T>  返回结果泛型
     * @return result
     */
    public static <T> Results<T> success(T data) {
        return new Results<>(200, "请求成功!", true, data);
    }

    /**
     * 返回数据类型为String 时使用
     *
     * @param data 返回数据
     * @return result
     */
    public static Results<String> success(String data){
        return new Results<>(200, "请求成功", true, data);
    }

    /**
     * 异常结果返回
     *
     * @param message 异常信息
     * @return result
     */
    public static Results<Object> error(String message) {
        return new Results<>(500, message, false, null);
    }

    /**
     * 异常结果返回
     *
     * @param code    结果码
     * @param message 异常信息
     * @return result
     */
    public static Results<Object> error(Integer code, String message) {
        return new Results<>(code, message, false, null);
    }

}
