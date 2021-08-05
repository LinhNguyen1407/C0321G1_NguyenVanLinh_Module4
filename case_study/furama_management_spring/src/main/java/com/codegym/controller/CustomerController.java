package com.codegym.controller;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.service.customer.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

//    @GetMapping
//    public ModelAndView showListCustomers () {
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        List<Customer> customerList = customerService.findAll();
//        modelAndView.addObject("customerList", customerList);
//        return modelAndView;
//    }
// sort = "", direction = Sort.Direction.ASC

    @GetMapping
    public ModelAndView showListCustomers(@PageableDefault(value = 5) Pageable pageable,
                                  @RequestParam Optional<String> keyword) {
        String keywordValue = "";
        if(keyword.isPresent()){
            keywordValue = keyword.get();
        }

        ModelAndView modelAndView = new ModelAndView("/customer/list");
        Page<Customer> customerList = customerService.findAll(pageable);
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }
}
