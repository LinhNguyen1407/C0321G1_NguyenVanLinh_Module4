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
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @GetMapping
    public ModelAndView showListCustomers (@PageableDefault(value = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        Page<Customer> customerList = customerService.findAllByFlagDelEquals(0, pageable);
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView showListSearchCustomers(@PageableDefault(value = 2) Pageable pageable,
                                  @RequestParam Optional<String> keyword) {
        String keywordValue = "";
        if(keyword.isPresent()){
            keywordValue = keyword.get();
        }

        ModelAndView modelAndView = new ModelAndView("/customer/list_search");
        Page<Customer> customerList = customerService.findAllByNameContainingOrAddressContaining(keywordValue, keywordValue, pageable);
        modelAndView.addObject("customerList", customerList);
        modelAndView.addObject("keywordValue", keywordValue);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        initCreateCustomer(model);
        return modelAndView;
    }

    private void initCreateCustomer(Model model) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
    }

    @PostMapping("/create")
    public String createCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {

        if(bindingResult.hasFieldErrors()) {
            initCreateCustomer(model);
            return "/customer/create";
        } else {
            Customer customer = new Customer();
            customerDto.setFlagDel(0);
            BeanUtils.copyProperties(customerDto, customer);

            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Create new customer " + customerDto.getName() + " successfull");
            return "redirect:/customer";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(), customerDto);

        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customerDto", customerDto);
        initCreateCustomer(model);
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

//    @PostMapping("/delete")
//    public String deleteCustomer(@RequestParam Long id,
//                                 RedirectAttributes redirectAttributes){
//        Optional<Customer> customer = customerService.findById(id);
//        customerService.delete(customer.get());
//        redirectAttributes.addFlashAttribute("message", "Delete customer " + customer.get().getName() + " successfull");
//        return "redirect:/customer";
//    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Long id,
                                 RedirectAttributes redirectAttributes){
        Optional<Customer> customer = customerService.findById(id);
        customer.get().setFlagDel(1);
        customerService.save(customer.get());
        redirectAttributes.addFlashAttribute("message", "Delete customer " + customer.get().getName() + " successfull");
        return "redirect:/customer";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showInforCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(), customerDto);
        ModelAndView modelAndView = new ModelAndView("/customer/detail");
        modelAndView.addObject("customerDto", customerDto);
        return modelAndView;
    }
}
