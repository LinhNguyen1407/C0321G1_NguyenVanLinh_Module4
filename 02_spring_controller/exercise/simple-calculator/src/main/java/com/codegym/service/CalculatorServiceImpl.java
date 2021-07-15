package com.codegym.service;

import com.codegym.repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    CalculatorRepository repository;

    @Override
    public String calculate(Float fOperator, Float sOperator, String operand) {
        return repository.calculate(fOperator, sOperator, operand);
    }
}
