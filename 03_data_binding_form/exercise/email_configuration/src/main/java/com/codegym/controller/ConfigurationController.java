package com.codegym.controller;

import com.codegym.model.EmailConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigurationController {

    @GetMapping("/configure")
    public String configure(Model model) {
        model.addAttribute("emailConf", new EmailConfiguration());
        return "configure";
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("emailConf") EmailConfiguration emailConf) {
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("emailConf", emailConf);
        return modelAndView;
    }
}
