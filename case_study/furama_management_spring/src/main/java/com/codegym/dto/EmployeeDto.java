package com.codegym.dto;

import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Position;
import com.codegym.model.entity.employee.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String name;
    private String birthday;
    private String idCard;
    private Long salary;
    private String phone;
    private String email;
    private String address;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private User user;
}
