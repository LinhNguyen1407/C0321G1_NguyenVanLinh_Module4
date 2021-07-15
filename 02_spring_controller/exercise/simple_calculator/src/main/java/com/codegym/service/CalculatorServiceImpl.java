package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String calculate(Float fOperator, Float sOperator, String operand) {
        float result = 0.0f;
        switch (operand) {
            case "Addition(+)":
                result = fOperator + sOperator;
                break;
            case "Subtraction(-)":
                result = fOperator - sOperator;
                break;
            case "Multiplication(x)":
                result = fOperator * sOperator;
                break;
            case "Division(/)":
                if (sOperator == 0) {
                    return "Lỗi ! phép chia cho 0.";
                }
                else  {
                    result = fOperator/sOperator;
                }
        }
        return String.valueOf(result);
    }
}
