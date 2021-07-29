package com.codegym.blog_application.controller;

import com.codegym.blog_application.model.bean.Blog;
import com.codegym.blog_application.model.bean.Category;
import com.codegym.blog_application.model.service.BlogService;
import com.codegym.blog_application.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryRestController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    BlogService blogService;

    @GetMapping("categorys/api")
    public ResponseEntity<Iterable<Category>> findAllCategory() {
        List<Category> categoryList = (List<Category>) categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("view-category/api/{id}")
    public ResponseEntity<Iterable<Blog>> viewCategory(@PathVariable("id") Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if(!categoryOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Blog> blogs = (List<Blog>) blogService.findAllByCategory(categoryOptional.get());
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
