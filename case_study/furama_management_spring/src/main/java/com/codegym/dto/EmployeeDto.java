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

    @NotEmpty(message = "Data must be not emmpty")
    private String name;

    @NotEmpty(message = "Data must be not emmpty")
    private String birthday;

    @NotEmpty(message = "Data must be not emmpty")
    @Pattern(regexp = "\\d{9}", message = "Id card must have format XXXXXXXXX, X is from 0 to 9")
    private String idCard;

    @NotNull(message = "Data must be not emmpty")
    @Min(1)
    private Long salary;

    @NotEmpty(message = "Data must be not emmpty")
    @Pattern(regexp = "(09\\d{8})|(\\(84\\)\\+9\\d{8})", message = "Phone must have format 09XXXXXXXX or (84)+9XXXXXXXX")
    private String phone;

    @NotEmpty(message = "Data must be not emmpty")
    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "Email must have form abc@xyz.vn")
    private String email;

    @NotEmpty(message = "Data must be not emmpty")
    private String address;

    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    @NotNull(message = "Data must be not emmpty")
    private User user;
}
