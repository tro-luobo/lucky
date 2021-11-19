package com.study.check.request;

import com.study.check.request.other.PoCheck;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author luobo
 * @desc 集合类型校验
 * @since 2021-11-18 16:13
 */
@Data
public class CollectionCheck {

    @UniqueElements(message = "元素不为空，且不为null")
    @NotEmpty(message = "元素值不能为空字符串，或者null")
    private ArrayList<String> strListCheck;

    @NotEmpty(message = "元素值不能为空字符串，或者null")
    private Map<String, Object> mapCheck;

    @Valid
    @NotNull(message = "不能为空")
    @Size(min = 1, max = 10, message = "元素个数超出范围")
    private List<PoCheck> poListCheck;

}
