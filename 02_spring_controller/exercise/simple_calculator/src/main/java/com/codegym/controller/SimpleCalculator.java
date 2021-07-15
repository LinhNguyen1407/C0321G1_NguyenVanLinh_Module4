package com.codegym.controller;

import com.codegym.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleCalculator {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/goCalculator")
    public String showCalculator() {
        return "calculator";
    }

    @RequestMapping (value = "/calculate")
    public String calculate(@RequestParam float firstOperator, float secondOperator, String operand, Model model) {

        model.addAttribute("firstOperator", firstOperator);
        model.addAttribute("secondOperator", secondOperator);
        model.addAttribute("operand", operand);
        model.addAttribute("result", calculatorService.calculate(firstOperator, secondOperator, operand));

        return "calculator";
    }
}
