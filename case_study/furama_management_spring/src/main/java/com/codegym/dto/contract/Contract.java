package com.codegym.dto.contract;

import com.codegym.dto.customer.Customer;
import com.codegym.dto.employee.Employee;
import com.codegym.dto.service.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    private Long id;
    private String startDate;
    private String endDate;
    private Long deposit;
    private Long totalMoney;
    private Employee employee;
    private Customer customer;
    private Service service;

}
