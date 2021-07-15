package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentController {

    @GetMapping(value = "/goCondiment")
    public String goCondiment() {

        return "goCondiment";
    }

    @RequestMapping(value = "/save")
    public String save(@RequestParam("condiment") String[] condiment, Model model) {

        model.addAttribute("condiments", condiment);
        return "save";
    }
}
