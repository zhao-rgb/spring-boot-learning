package com.soft1851.verify.entity;

import com.soft1851.verify.annotation.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author zhao
 * @className Person
 * @Description TODO
 * @Date 2020/4/30
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @NotNull(message = "Id 不能为空")
//    @Size(min = 6, max = 10)
    private String id;

    @NotNull(message = "name 不能为空")
//    @Size(max = 10)
    private String name;

    @Min(18)
    private Integer age;

//    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
//    @NotNull(message = "手机号码不能为空")
    @PhoneNumber(message = "PhoneNumber格式、长度不正确")
    @NotNull(message = "PhoneNumber 不能为空")
    private String phone;

    @NotNull(message = "email 不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

    @Pattern(regexp = "((^Man$|^Woman$|^UGM$))", message = "sex 值不在可选范围")
    @NotNull(message = "sex 不能为空")
    private String sex;
}
