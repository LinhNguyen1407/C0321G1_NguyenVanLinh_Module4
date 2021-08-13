package com.codegym.dto;

import com.codegym.model.entity.customer.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements Validator {

    private Long id;

    //    @NotEmpty(message = "Data must be not empty")
//    @Pattern(regexp = "KH-\\d{4}",message = "Customer code must have format KH-XXXX")
    private String code;

    @NotEmpty(message = "Data must be not empty")
    private String name;

    @NotEmpty(message = "Data must be not empty")
    private String birthday;

    @NotEmpty(message = "Data must be not empty")
    private String gender;

    @NotEmpty(message = "Data must be not empty")
    @Pattern(regexp = "\\d{9}", message = "Id card must have format XXXXXXXXX, X is from 0 to 9")
    private String idCard;

    @NotEmpty(message = "Data must be not empty")
    @Pattern(regexp = "(09\\d{8})|(\\(84\\)\\+9\\d{8})", message = "Phone must have format 09XXXXXXXX or (84)+9XXXXXXXX")
    private String phone;

    @NotEmpty(message = "Data must be not empty")
    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "Email must have form abc@xyz.vn")
    private String email;

    @NotEmpty(message = "Data must not be empty")
    private String address;

    private int flagDel;
    private CustomerType customerType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar period = Calendar.getInstance();
        Date date = null;
        try {
            date = dateFormat.parse(customerDto.getBirthday());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date != null) {
            period.setTime(date);
        }
        period.add(Calendar.DATE, 18 * 365);
        if (period.getTimeInMillis() - System.currentTimeMillis() > 0) {
            errors.rejectValue("birthday", "birthday", "Age must be not less than 18");
        }
    }
}
