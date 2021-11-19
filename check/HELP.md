## **spring validation 使用说明**
### 首先使用spring boot需要引入以下依赖
    <dependency>
        <groupId>javax.validation</groupId>
        <artifactId>validation-api</artifactId>
        <version>2.0.1.Final</version>
    </dependency>
    
    或者
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
### @Validated 与 @Valid 区别, 以及使用
    @Validated 可用在类型，方法，方法参数，不能用在类成员属性上
    
    @Valid 可用在方法，构造函数，方法参数和成员属性上
    
    区别：在于能否用于成员属性上影响嵌套验证功能
    
### 统一返回对象封装类
    ReqExceptionResults
### 统一结果处理自定义配置类
    ValidatorHandlerAdvice.supports 方法
    使用：如果返回结果已经为 Results返回结果, 不执行 beforeBodyWrite
    
    ValidatorHandlerAdvice.beforeBodyWrite方法
    使用：参数body是响应对象response中的响应体，那么我们就可以用此方法来对响应体做一些统一的操作。比如加密，签名等。
### 统一异常结果处理自定义配置类
    GlobalExceptionHandler
### 常用注解说明
#### JSR 提供的校验注解 javax.validation.constraints
    @NotEmpty(message = "元素不为空，且不为null")
    @NotBlank(message = "不能为空，并且不能为 null")
    @Null(message = "被注释的元素必须为null")
    @NotNull(message = "不能为null,但可以为空字符串")
    @Pattern(regex="正则表达式", message = "被注释的元素必须满足正则表达式")
    @Size(max = 最大, min = 最小 message = "被注释集合元素数量必须在此范围内")
    @AssertFalse(message = "被注释的元素必须为false")
    @AssertTrue(message = "被注释的元素必须为true")
    @Max(value = 最大范围值, message = "被注释的元素必须是一个数字，其值必须大于等于指定的最小值")
    @Min(value = 最小范围值, message = "被注释的元素必须是一个数字，其值必须小于等于指定的最大值")
    @DecimalMax(value = "最大值", message = "被注释的元素必须是一个数字，其值必须小于等于指定的最大值")
    @DecimalMin(value = "最小值", message = "被注释的元素必须是一个数字，其值必须大于等于指定的最小值")
    @Digits(integer = 整数位, fraction = 小数位, message = "被注释的元素必须是一个数字，其值必须在可接受的范围内")
    @Past(message = "被注释的元素必须是一个过去的日期")
    @PastOrPresent(message = "被注释的元素必须是一个过去的日期 或者当前")
    @Future(message = "被注释的元素必须是一个将来的日期")
    @FutureOrPresent(message = "被注释的元素必须是一个将来的日期 或者当前")
    @Email(message = "字符串必须是Email地址")
    @Negative(message = "验证元素是否为负数")
    @NegativeOrZero(message = "验证元素是否为负数或零")
    @Positive(message = "验证元素是否为正数")
    @PositiveOrZero(message = "验证元素是否为正数或零")

#### Hibernate Validator提供的校验注解 org.hibernate.validator.constraints
    @URL(message = "字符串必须是合法的URL")
    @CreditCardNumber(ignoreNonDigitCharacters = 忽略非数字字符 true/false, message = "字符串必须是信用卡号,按照美国的标准验证") 
    @Length(max = 最大范围, min = 最小范围, message = "被注释的字符串的大小必须在指定的范围内")
    @Range(min = 最小范围, max = 最大范围, message = "被注释的元素必须在合适的范围内")
    @EAN(message = "是否是有效的国际商品编号，null 是有效的")
    @CodePointCount(message = "字符串中点的个数")
    @CreditCardNumber(ignoreNonDigitCharacters = "允许忽略非数字字符，默认值为false", message = "检查字符序列是否通过Luhn校验和测试。请注意，此验证旨在检查用户错误，而不是信用卡有效性")
    @Currency(message = "检查注解的货币单位 javax.money.MonetaryAmount 是否为指定货币单位的一部分")
    @ISBN(message = "是否是有效的国际标准书号，null 是有效的")
    @UniqueElements(message = "检测集合中的值都是唯一的(集合不能包含相同的元素，null 是有效的)")
    @LuhnCheck(message = "检查字符序列中的数字是否通过Luhn校验和算法")
    @Mod10Check(message = "检查字符序列中的数字是否通过通用mod 10校验和算法")
    @Mod11Check(message = "检查字符序列中的数字是否通过通用mod 11校验和算法")
    
### 使用示例
    com.study.check.request 包下面提供了常用类型校验示例