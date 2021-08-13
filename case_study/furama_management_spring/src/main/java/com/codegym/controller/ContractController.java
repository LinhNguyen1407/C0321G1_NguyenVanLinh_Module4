package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import com.codegym.model.service.contract.ContractService;
import com.codegym.model.service.customer.CustomerService;
import com.codegym.model.service.employee.EmployeeService;
import com.codegym.model.service.service.ServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ModelAndView showListContracts(@PageableDefault(value = 4) Pageable pageable) {
        contractService.calculateTotalMoney();
        ModelAndView modelAndView = new ModelAndView("/contract/list");
        Page<Contract> contractList = contractService.findAll(pageable);
        modelAndView.addObject("contractList", contractList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("/contract/create");
        modelAndView.addObject("contractDto", new ContractDto());
        initCreateContract(model);
        return modelAndView;
    }

    @PostMapping("/create")
    public String createContract(@Validated @ModelAttribute ContractDto contractDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            initCreateContract(model);
            return "/contract/create";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);

            contractService.save(contract);
            redirectAttributes.addFlashAttribute("message", "Create new contract with ID " + contract.getId() + " successfull");
            return "redirect:/contract";
        }
    }

    private void initCreateContract(Model model) {
        List<Customer> customerList = customerService.findAllByFlagDel();
        model.addAttribute("customerList", customerList);
        List<Service> serviceList = serviceService.findAll();
        model.addAttribute("serviceList", serviceList);
        List<Employee> employeeList = employeeService.findAllByFlagDel();
        model.addAttribute("employeeList", employeeList);
    }
}
