package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract.ContractDetail;
import com.codegym.model.entity.service.AttachService;
import com.codegym.model.service.contract.ContractDetailService;
import com.codegym.model.service.contract.ContractService;
import com.codegym.model.service.service.AttachServiceService;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ContractDetailController {

    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private AttachServiceService attachServiceService;

    @GetMapping("/contract-detail")
    public ModelAndView showListContractDetails(@PageableDefault(value = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/contract_detail/list");
        Page<ContractDetail> contractDetails = contractDetailService.findAll(pageable);
        modelAndView.addObject("contractDetails", contractDetails);
        return modelAndView;
    }

    @GetMapping("/contract-detail/create")
    public ModelAndView showCreateForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("/contract_detail/create");
        modelAndView.addObject("contractDetailDto", new ContractDetailDto());
        initCreateContractDetail(model);
        return modelAndView;
    }

    private void initCreateContractDetail(Model model) {
        List<Contract> contractList = contractService.findAll();
        model.addAttribute("contractList", contractList);
        List<AttachService> attachServices = attachServiceService.findAll();
        model.addAttribute("attachServices", attachServices);
    }

    @PostMapping("/contract-detail/create")
    public String createContractDetail(@Validated @ModelAttribute ContractDetailDto contractDetailDto,
                                       BindingResult bindingResult,
                                       RedirectAttributes redirectAttributes,
                                       Model model) {
        if(bindingResult.hasFieldErrors()) {
            initCreateContractDetail(model);
            return "/contract_detail/create";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            contractDetailService.save(contractDetail);
            redirectAttributes.addFlashAttribute("message", "Create new contract detail with ID " + contractDetail.getId() + " successfull");
            return "redirect:/contract-detail";
        }
    }

    @GetMapping("/customer/use-service")
    public ModelAndView showListCustomerUsedService(@PageableDefault(value = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/customer/use_service");
        contractDetailService.calculateTotalMoney();
        Page<ContractDetail> contractDetails = contractDetailService.findCustomerByStatus(pageable);
        modelAndView.addObject("contractDetails", contractDetails);
        return modelAndView;
    }
}
