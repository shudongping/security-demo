package com.imooc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author shudp
 * @create 2017/12/7.
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object>{



    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        System.out.println(value);

        return false;
    }
}
