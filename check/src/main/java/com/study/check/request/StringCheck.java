package com.study.check.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

/**
 * @author luobo
 * @desc 字符串校验
 * @since 2021-11-18 17:30
 */
@Data
public class StringCheck {

    @Length(min = 1, max = 10, message = "字符串长度范围1 - 10")
    @NotBlank(message = "不能为空")
    private String strCheck;

    @Null(message = "必须为空")
    private String strCheckIsNull;

}
