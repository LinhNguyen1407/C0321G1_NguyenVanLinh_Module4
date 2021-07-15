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
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment, Model model) {

        if (condiment != null) {
            model.addAttribute("condiments", condiment);
            model.addAttribute("message", "");
        } else {
            model.addAttribute("message", "Not found condiment");
        }

        return "save";
    }
}
