package com.codegym.dto;

import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Position;
import com.codegym.model.entity.employee.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;

    @NotEmpty(message = "Data must be not empty")
    private String name;

    @NotEmpty(message = "Data must be not empty")
    private String birthday;

    @NotEmpty(message = "Data must be not empty")
    @Pattern(regexp = "\\d{9}", message = "Id card must have format XXXXXXXXX, X is from 0 to 9")
    private String idCard;

    @NotNull(message = "Data must be not empty")
    @Positive(message = "Salary must be greater than 0")
    private Long salary;

    @NotEmpty(message = "Data must be not empty")
    @Pattern(regexp = "(09\\d{8})|(\\(84\\)\\+9\\d{8})", message = "Phone must have format 09XXXXXXXX or (84)+9XXXXXXXX")
    private String phone;

    @NotEmpty(message = "Data must be not empty")
    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "Email must have form abc@xyz.vn")
    private String email;

    @NotEmpty(message = "Data must be not empty")
    private String address;

    private int flagDel;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    @NotNull(message = "Data must be not empty")
    private User user;
}
