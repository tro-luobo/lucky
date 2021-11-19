package com.study.check.request.other;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author luobo
 * @desc 校验测试用
 * @since 2021-11-18 16:47
 */
@Data
public class PoCheck {

    @NotBlank(message = "不能为空")
    private String name;

    @NotNull(message = "不能为空")
    @Max(value = 120, message = "不能大于120")
    @Min(value = 0, message = "不能等于0")
    @Positive(message = "必须为正整数")
    private Integer age;
}
