package com.codegym.controller;

import com.codegym.model.entity.Book;
import com.codegym.model.service.BookService;
import com.codegym.exception.OutOfQuantityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ModelAndView getListBooks() {
        ModelAndView modelAndView = new ModelAndView("/books/list");
        List<Book> listBooks = bookService.findAll();
        modelAndView.addObject("books", listBooks);
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/books/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message","Create new book successfull with name " + book.getName());
        return "redirect:/book";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showInforOfBook(@PathVariable("id") Integer id){
        Optional<Book> bookOptional = bookService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/books/infor");
        modelAndView.addObject("book", bookOptional.get());
        return modelAndView;
    }

    @PostMapping("update-borrow/{id}")
    public String updateRemainingBooks(@PathVariable("id") Integer id,
                             RedirectAttributes redirectAttributes) throws OutOfQuantityException {
        Optional<Book> bookOptional = bookService.findById(id);
        Book book = bookOptional.get();
        if (book.getQuantity() == 0) {
            throw new OutOfQuantityException();
        }
        book.setQuantity(book.getQuantity() - 1 );
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message","Update quantity after borrow for " + book.getName());
        return "redirect:/book";
    }

    @GetMapping("update-get")
    public String showGetBook() {
        return "/books/get";
    }

    @PostMapping("update-get")
    public String GetBookAgain(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        Optional<Book> bookOptional = bookService.findById(id);
        if(!bookOptional.isPresent()){
            redirectAttributes.addFlashAttribute("message","The code is incorrect, please re-enter it");
            return "redirect:/book/update-get";
        }
        Book book = bookOptional.get();
        book.setQuantity(book.getQuantity() + 1 );
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message","Update quantity after give back for " + book.getName());
        return "redirect:/book";
    }

    @ExceptionHandler(OutOfQuantityException.class)
    public String showErrorPage() {
        return "/books/error";
    }
}
