package com.codegym.blog_application.controller;

import com.codegym.blog_application.model.bean.Blog;
import com.codegym.blog_application.model.service.BlogService;
import com.codegym.blog_application.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class BlogRestController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/blogs/search")
    public ResponseEntity<Iterable<Blog>> searchBlogs(@RequestParam(value = "keyword") Optional<String> keyword) {
        String keywordValue = "";
        if(keyword.isPresent()){
            keywordValue = keyword.get();
        }
        List<Blog> blogList = (List<Blog>) blogService.findAllByTitleContaining(keywordValue);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<Page<Blog>> listBlogs(@PageableDefault(value = 2) Pageable pageable) {
        Page<Blog> blogList = blogService.findAll(pageable);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
