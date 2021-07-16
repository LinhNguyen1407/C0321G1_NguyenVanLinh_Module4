package com.codegym.controller;

import com.codegym.model.EmailConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigurationController {

    @GetMapping("/configure")
    public ModelAndView configure () {
        return new ModelAndView("configure", "emailConf", new EmailConfiguration());
    }

    @PostMapping("/update")
    public ModelAndView update (@ModelAttribute("emailConf") EmailConfiguration emailConf) {
        ModelAndView modelAndView = new ModelAndView("showUpdate");
        modelAndView.addObject("emailConfiguration", emailConf);
        return modelAndView;
    }
}
