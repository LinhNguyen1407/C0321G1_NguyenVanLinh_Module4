package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConvertCurrencyController {
    @RequestMapping(value = "/convert-currency")
    public String convertCurrency(String rate, String usd, Model model) {

        float vnd = Float.parseFloat(rate) * Float.parseFloat(usd);

        model.addAttribute("rate" , rate);
        model.addAttribute("usd" , usd);
        model.addAttribute("vnd" , vnd);

        return "convert";
    }
}
