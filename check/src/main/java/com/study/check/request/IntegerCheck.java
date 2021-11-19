package com.study.check.request;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author luobo
 * @desc 整型校验
 * @since 2021-11-18 15:16
 */
@Data
public class IntegerCheck {

    @NotNull(message = "不能为空")
    @Max(value = 10, message = "最大10")
    @Min(value = 1, message = "必须大于1")
    @DecimalMax(value = "9", message = "小于等于9")
    @DecimalMin(value = "2", message = "大于等于2")
    @Digits(integer = 1, fraction = 0, message = "数字必须在此范围内")
    @Positive(message = "验证元素是否为正数")
    @PositiveOrZero(message = "验证元素是否为正数或零")
    private Integer intCheck;

    @Null(message = "必须为null")
    private Integer intNullCheck;

    @Negative(message = "验证元素是否为负数")
    @NegativeOrZero(message = "验证元素是否为负数或零")
    private Integer intNegativeCheck;

}
