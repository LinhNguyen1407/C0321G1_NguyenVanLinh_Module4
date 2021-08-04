package com.codegym.blog_application.controller;

import com.codegym.blog_application.model.entity.Blog;
import com.codegym.blog_application.model.entity.Category;
import com.codegym.blog_application.model.service.BlogService;
import com.codegym.blog_application.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categorys")
    public Iterable<Category> categorys(){
        return categoryService.findAll();
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/blogs")
    public ModelAndView listBlogs(@PageableDefault(value = 3, sort = "createdTime", direction = Sort.Direction.ASC) Pageable pageable,
                                  @RequestParam Optional<String> keyword) {
        String keywordValue = "";
        if(keyword.isPresent()){
            keywordValue = keyword.get();
        }

        ModelAndView modelAndView = new ModelAndView("/blog/list");
        Page<Blog> blogs = blogService.findAllByTitleContaining(keywordValue, pageable);
        modelAndView.addObject("keywordValue", keywordValue);
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog.get());
        return modelAndView;
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        return "redirect:blogs";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView viewCategory(@PathVariable("id") Long id){
        Optional<Blog> blogOptional = blogService.findById(id);
        if(!blogOptional.isPresent()){
            return new ModelAndView("/blog/error");
        }

        ModelAndView modelAndView = new ModelAndView("/blog/view");
        modelAndView.addObject("blog", blogOptional.get());
        return modelAndView;
    }

    @GetMapping(value = "/403")
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }
}
