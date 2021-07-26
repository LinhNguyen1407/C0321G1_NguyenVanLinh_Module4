package com.codegym.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Setter
@Getter
@NoArgsConstructor
public class UserDto implements Validator {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private Integer age;
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        ValidationUtils.rejectIfEmpty(errors, "firstName", "field.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "field.empty");
        ValidationUtils.rejectIfEmpty(errors, "phone", "field.empty");
        ValidationUtils.rejectIfEmpty(errors, "age", "field.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "field.empty");


        if (userDto.firstName.length() > 45) {
            errors.rejectValue("firstName", "firstName.length");
        }
        if (userDto.lastName.length() < 5 || userDto.lastName.length() > 45) {
            errors.rejectValue("lastName", "lastName.length");
        }

        if (userDto.phone.length() > 11 || userDto.phone.length() < 10) {
            errors.rejectValue("phone", "phone.length");
        }
        if (!userDto.phone.startsWith("0")) {
            errors.rejectValue("phone", "phone.startsWith");
        }
        if (!userDto.phone.matches("(^[0-9]*$)")) {
            errors.rejectValue("phone", "phone.matches");
        }

        if (userDto.age < 18) {
            errors.rejectValue("age", "age.notEnough");
        }

        if (!userDto.email.matches("^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")) {
            errors.rejectValue("email", "email.matches");
        }
    }
}
