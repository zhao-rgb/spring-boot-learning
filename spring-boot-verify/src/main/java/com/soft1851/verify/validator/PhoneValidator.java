package com.soft1851.verify.validator;

import com.soft1851.verify.annotation.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author zhao
 * @className PhoneValidator
 * @Description TODO
 * @Date 2020/4/30
 * @Version 1.0
 **/
public class PhoneValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // 验证手机号
        Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
        return p.matcher(s).matches();
    }
}
