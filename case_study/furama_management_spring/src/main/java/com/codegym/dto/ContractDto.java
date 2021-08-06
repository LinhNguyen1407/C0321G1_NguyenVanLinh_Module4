package com.codegym.dto;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto {

    private Long id;
    private String startDate;
    private String endDate;
    private Long deposit;
    private Long totalMoney;
    private Employee employee;
    private Customer customer;
    private Service service;

}
