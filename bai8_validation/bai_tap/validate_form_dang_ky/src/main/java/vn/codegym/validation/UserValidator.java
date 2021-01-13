package vn.codegym.validation;

import vn.codegym.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidator implements ConstraintValidator<User,String> {
    @Override
    public void initialize(User constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
