package com.codegym.dto;

import com.codegym.model.entity.customer.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Long id;
    private String code;
    private String name;
    private String birthday;
    private String gender;
    private String idCard;
    private String phone;
    private String email;
    private String address;
    private CustomerType customerType;
}
