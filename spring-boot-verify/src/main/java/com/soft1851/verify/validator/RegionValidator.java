package com.soft1851.verify.validator;


import com.soft1851.verify.annotation.Region;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

/**
 * @author zhao
 * @className RegionValidator
 * @Description 自定义校验规则
 * @Date 2020/4/30
 * @Version 1.0
 **/
public class RegionValidator implements ConstraintValidator<Region,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        HashSet<Object> regions = new HashSet<>();
        regions.add("China");
        regions.add("China-Taiwan");
        regions.add("China-HongKong");
        return regions.contains(s);
    }
}
