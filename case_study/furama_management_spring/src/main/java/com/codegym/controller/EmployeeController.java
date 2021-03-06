package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.model.entity.employee.*;
import com.codegym.model.service.employee.DivisionService;
import com.codegym.model.service.employee.EducationDegreeService;
import com.codegym.model.service.employee.EmployeeService;
import com.codegym.model.service.employee.PositionService;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private EducationDegreeService educationDegreeService;

    @Autowired
    private DivisionService divisionService;

    @GetMapping
    public ModelAndView showListEmployees(@PageableDefault(value = 4) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        Page<Employee> employeeList = employeeService.findAllByFlagDel(pageable);
        modelAndView.addObject("employeeList", employeeList);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView showListSearchEmployees(@PageableDefault(value = 4) Pageable pageable,
                                                @RequestParam Optional<String> name,
                                                @RequestParam Optional<String> idCard) {
        String nameValue = "";
        String idCardValue = "";
        if (name.isPresent()) {
            nameValue = name.get();
        }
        if (idCard.isPresent()) {
            idCardValue = idCard.get();
        }

        ModelAndView modelAndView = new ModelAndView("/employee/list_search");
        Page<Employee> employeeList = employeeService.searchByNameAndIdCard(nameValue, idCardValue, pageable);
        modelAndView.addObject("employeeList", employeeList);
        modelAndView.addObject("nameValue", nameValue);
        modelAndView.addObject("idCardValue", idCardValue);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employeeDto", new EmployeeDto());

        initCreateEmployee(model);
        return modelAndView;
    }

    @PostMapping("/create")
    public String createEmployee(@Validated @ModelAttribute EmployeeDto employeeDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            initCreateEmployee(model);
            return "/employee/create";
        } else {
            Employee employee = new Employee();
            employeeDto.setFlagDel(0);
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Create new employee " + employee.getName() + " successfull");
            return "redirect:/employee";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id, Model model) {
        Optional<Employee> employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee.get(), employeeDto);

        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("employeeDto", employeeDto);

        initCreateEmployee(model);
        return modelAndView;
    }

    private void initCreateEmployee(Model model) {
        List<Position> positionList = positionService.findAll();
        model.addAttribute("positionList", positionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        model.addAttribute("educationDegreeList", educationDegreeList);
        List<Division> divisionList = divisionService.findAll();
        model.addAttribute("divisionList", divisionList);
    }

    @PostMapping("/edit")
    public String updateEmployee(@Validated @ModelAttribute EmployeeDto employeeDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            initCreateEmployee(model);
            return "/employee/edit";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Update employee " + employee.getName() + " successfull");
            return "redirect:/employee";
        }
    }

//    @PostMapping("/delete")
//    public String deleteEmployee(@RequestParam Long id,
//                                 RedirectAttributes redirectAttributes){
//        Optional<Employee> employee = employeeService.findById(id);
//        employeeService.delete(employee.get());
//        redirectAttributes.addFlashAttribute("message", "Delete employee " + employee.get().getName() + " successfull");
//        return "redirect:/employee";
//    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam Long id,
                                 RedirectAttributes redirectAttributes) {
        Optional<Employee> employee = employeeService.findById(id);
        employee.get().setFlagDel(1);
        employeeService.save(employee.get());
        redirectAttributes.addFlashAttribute("message", "Delete employee " + employee.get().getName() + " successfull");
        return "redirect:/employee";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showInforEmployee(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee.get(), employeeDto);

        ModelAndView modelAndView = new ModelAndView("/employee/detail");
        modelAndView.addObject("employeeDto", employeeDto);
        return modelAndView;
    }
}
