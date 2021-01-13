package vn.codegym.entity;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.lang.annotation.Annotation;

@Component
public class User implements Validator, Annotation {
    @NotNull
    @Size(min = 5,max = 45)
    private String firstName;
    @NotNull
    @Size(min = 5,max = 45)
    private String lastName;
    private String phoneNumber;
    @Min(18)
    private int age;


    @Email
    @NotEmpty
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.phoneNumber.length() > 11 || user.phoneNumber.length() < 10){
            errors.rejectValue("phoneNumber","sizePhoneNumber.combined");
        }
        if (!user.phoneNumber.startsWith("0")){
            errors.rejectValue("phoneNumber","startPhoneNumber.combined");
        }
        if (!user.phoneNumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber","PhoneNumber.combined");
        }

    }
}
