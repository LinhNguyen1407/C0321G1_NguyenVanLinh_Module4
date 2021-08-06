package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import com.codegym.model.service.customer.CustomerTypeService;
import com.codegym.model.service.customer.impl.CustomerServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

//    @GetMapping
//    public ModelAndView showListCustomers () {
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        List<Customer> customerList = customerService.findAll();
//        modelAndView.addObject("customerList", customerList);
//        return modelAndView;
//    }
// sort = "", direction = Sort.Direction.ASC

    @GetMapping
    public ModelAndView showListCustomers(@PageableDefault(value = 2) Pageable pageable,
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

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        modelAndView.addObject("customerTypeList", customerTypeList);
        return modelAndView;
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute CustomerDto customerDto,
                                 RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create customer " + customerDto.getName() + " successfull");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(), customerDto);

        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customerDto", customerDto);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        modelAndView.addObject("customerTypeList", customerTypeList);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute CustomerDto customerDto,
                                 RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Update customer " + customer.getName() + " successfull");
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Long id){
        Optional<Customer> customer = customerService.findById(id);
        customerService.delete(customer.get());
        return "redirect:/customer";
    }
}
