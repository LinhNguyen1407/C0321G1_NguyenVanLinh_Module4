package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.entity.User;
import com.codegym.model.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String getListUsers(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "user/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/create";
    }

    @PostMapping("/create")
    public String saveUser(@Validated @ModelAttribute("userDto") UserDto userDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto, bindingResult);
        if(bindingResult.hasFieldErrors()) {
            return "user/create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            redirectAttributes.addFlashAttribute("message", "New user created successfully");
            return "redirect:/user";
        }
    }
}
