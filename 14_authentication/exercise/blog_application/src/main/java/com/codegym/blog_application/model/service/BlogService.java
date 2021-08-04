package com.codegym.blog_application.model.service;

import com.codegym.blog_application.model.entity.Blog;
import com.codegym.blog_application.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService extends GeneralService<Blog> {

    Iterable<Blog> findAllByCategory(Category category);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByTitleContaining(String name, Pageable pageable);
}
