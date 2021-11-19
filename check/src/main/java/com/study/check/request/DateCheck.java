package com.study.check.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author luobo
 * @desc 时间日期类型校验
 * @since 2021-11-18 15:42
 */
@Data
public class DateCheck {

    @NotNull(message = "不能为空")
    @Future(message = "日期必须为将来")
    @FutureOrPresent(message = "日期必须为将来或者当前")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateCheck;

    @Past(message = "日期必须为过去")
    @PastOrPresent(message = "日期必须为过去或者当前")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private LocalDate localDateCheck;

    @Null(message = "必须为空")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTimeCheck;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm:ss")
    private LocalTime localTimeCheck;
}
