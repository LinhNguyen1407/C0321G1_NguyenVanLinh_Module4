package com.codegym.model.service;

import com.codegym.model.bean.Blog;
import java.util.List;

public interface BlogService {

    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

//    void update(Blog blog);

    void remove(Integer id);
}
