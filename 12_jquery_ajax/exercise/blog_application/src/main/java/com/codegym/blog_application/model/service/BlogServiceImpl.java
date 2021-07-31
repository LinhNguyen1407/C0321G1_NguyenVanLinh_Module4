package com.codegym.blog_application.model.service;

import com.codegym.blog_application.model.bean.Blog;
import com.codegym.blog_application.model.repository.BlogRepository;
import com.codegym.blog_application.model.bean.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;


    @Override
    public Iterable<Blog> findAllByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Iterable<Blog> findAllByTitleContaining(String name) {
        return blogRepository.findAllByTitleContaining(name);
    }

//    @Override
//    public Page<Blog> findAllByTitleContaining(String name, Pageable pageable) {
//        return blogRepository.findAllByTitleContaining(name, pageable);
//    }

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }
}
