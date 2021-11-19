package com.study.check.request;

import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

/**
 * @author luobo
 * @desc Boolean类型校验
 * @since 2021-11-18 15:38
 */
@Data
public class BooleanCheck {

    /**
     * 校验属性
     *
     * 以下也可以用来进行校验
     * @Null(message = "被注释的元素必须为null")
     * @AssertFalse(message = "被注释的元素必须为false")
     */
    @NotNull(message = "不能为null,但可以为空字符串")
    @AssertTrue(message = "被注释的元素必须为true")
    private Boolean booleanCheck;

}
