package com.codegym.controller;

import com.codegym.dto.ServiceDto;
import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.Service;
import com.codegym.model.entity.service.ServiceType;
import com.codegym.model.service.service.RentTypeService;
import com.codegym.model.service.service.ServiceService;
import com.codegym.model.service.service.ServiceTypeService;
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
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private RentTypeService rentTypeService;


    @GetMapping
    public ModelAndView showListServices(@PageableDefault(value = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/service/list");
        Page<Service> serviceList = serviceService.findAll(pageable);
        modelAndView.addObject("serviceList", serviceList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("/service/create");
        modelAndView.addObject("serviceDto", new ServiceDto());

        initCreateService(model);
        return modelAndView;
    }

    private void initCreateService(Model model) {
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();
        model.addAttribute("serviceTypeList", serviceTypeList);
        List<RentType> rentTypeList = rentTypeService.findAll();
        model.addAttribute("rentTypeList", rentTypeList);
    }

    @PostMapping("/create")
    public String createService(@Validated @ModelAttribute ServiceDto serviceDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        if(bindingResult.hasFieldErrors()){
            initCreateService(model);
            return "/service/create";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);

            serviceService.save(service);
            redirectAttributes.addFlashAttribute("message", "Create new service " + service.getName() + " successfull");
            return "redirect:/service";
        }
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showInforService(@PathVariable Long id) {
        Optional<Service> service = serviceService.findById(id);
        ServiceDto serviceDto = new ServiceDto();
        BeanUtils.copyProperties(service.get(), serviceDto);

        ModelAndView modelAndView = new ModelAndView("/service/detail");
        modelAndView.addObject("serviceDto", serviceDto);
        return modelAndView;
    }
}
