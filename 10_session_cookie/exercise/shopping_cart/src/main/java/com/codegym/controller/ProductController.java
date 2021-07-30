package com.codegym.controller;

import com.codegym.model.entity.Cart;
import com.codegym.model.entity.Product;
import com.codegym.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute Cart cart,
                            @RequestParam("action") String action,
                            @RequestParam("quantityChange") String quantityChange,
                            RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            if(quantityChange.equals("increase")) {
                cart.addProduct(productOptional.get());
                return "redirect:/shopping-cart";
            }
            cart.removeProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        redirectAttributes.addFlashAttribute("message",productOptional.get().getName() + " was added to cart");
        return "redirect:/shop";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showInfor(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/infor");
        modelAndView.addObject("product", productService.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/payment")
    public ModelAndView payment(@SessionAttribute("cart") Cart cart, Model model) {
        ModelAndView modelAndView = new ModelAndView("/payment");
        model.addAttribute("payment", cart.countTotalPayment());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String removeItemFromCart(@PathVariable Long id, @SessionAttribute Cart cart) {
        cart.removeItemFromCart(productService.findById(id).get());
        return "redirect:/shopping-cart";
    }
}