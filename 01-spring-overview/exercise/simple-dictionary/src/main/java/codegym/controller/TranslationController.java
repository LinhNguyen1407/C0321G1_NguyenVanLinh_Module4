package codegym.controller;

import codegym.serivice.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TranslationController {

    @GetMapping (value = "/dictionary")
    public String showForm () {
        return "input";
    }

    @Autowired
    DictionaryService service;

    @PostMapping (value = "/translate")
    public String translate (String txtSearch, Model model) {

        model.addAttribute("word", txtSearch);
        model.addAttribute("result", service.find(txtSearch));

        return "translate";
    }
}
