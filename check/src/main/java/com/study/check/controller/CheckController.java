package com.study.check.controller;

import com.study.check.request.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luobo
 * @desc 校验实验控制器
 * @since 2021-11-18 10:19
 */
@Slf4j
@RestController
@RequestMapping("check")
public class CheckController {

    @PostMapping("/integer")
    public void checkInteger(@RequestBody @Validated IntegerCheck req){
        log.info("integer 校验通过");
    }

    @PostMapping("/boolean")
    public void checkBoolean(@RequestBody @Validated BooleanCheck req){
        log.info("boolean 校验通过");
    }

    @PostMapping("/date")
    public void checkDate(@RequestBody @Validated DateCheck req){
        log.info("date 校验通过");
    }

    @PostMapping("/collection")
    public void checkCollection(@RequestBody @Validated CollectionCheck req){
        log.info("collection 校验通过");
    }

    @PostMapping("/string")
    public void checkString(@RequestBody @Validated StringCheck req){
        log.info("String 校验通过");
    }
}
