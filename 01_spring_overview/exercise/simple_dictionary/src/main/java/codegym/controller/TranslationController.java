package codegym.controller;

import codegym.serivice.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TranslationController {
    @Autowired
    DictionaryService dictionaryService;

    @GetMapping (value = "/dictionary")
    public String showForm () {
        return "input";
    }

    @PostMapping (value = "/translate")
    public String translate (String txtSearch, Model model) {

        model.addAttribute("word", txtSearch);
        model.addAttribute("result", dictionaryService.find(txtSearch));

        return "translate";
    }
}
