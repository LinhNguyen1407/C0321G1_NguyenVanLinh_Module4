package codegym.controller;

import codegym.service.ConvertCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConvertCurrencyController {

    @Autowired
    ConvertCurrencyService convertCurrencyService;

    @RequestMapping(value = "/convert-currency")
    public String convertCurrency(float rate, float usd, Model model) {

        model.addAttribute("rate" , rate);
        model.addAttribute("usd" , usd);
        model.addAttribute("vnd" , convertCurrencyService.convert(rate,usd));

        return "convert";
    }
}
