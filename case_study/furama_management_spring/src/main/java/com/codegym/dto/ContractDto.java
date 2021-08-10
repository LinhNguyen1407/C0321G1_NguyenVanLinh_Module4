package com.codegym.dto;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto implements Validator {

    private Long id;

    @NotEmpty(message = "Data must be not empty")
    private String startDate;

    @NotEmpty(message = "Data must be not empty")
    private String endDate;

    @NotNull(message = "Data must be not empty")
    @Positive(message = "Deposit must be greater than 0")
    private Long deposit;

    private Long totalMoney;
    private Employee employee;
    private Customer customer;
    private Service service;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;

        int timeDiff = contractDto.getStartDate().compareTo(LocalDate.now().toString());
        if(timeDiff < 0) {
            errors.rejectValue("startDate", "startDate","Start date must be not in past");
        }

        int period = contractDto.getEndDate().compareTo(contractDto.getStartDate());
        if(period < 0) {
            errors.rejectValue("endDate", "endDate","End date must not be less than start date");
        }
    }
}
