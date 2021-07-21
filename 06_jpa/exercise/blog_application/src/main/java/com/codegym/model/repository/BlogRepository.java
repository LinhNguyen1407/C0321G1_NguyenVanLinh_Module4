package com.codegym.model.repository;

import com.codegym.model.bean.Blog;
import java.util.List;

public interface BlogRepository {

    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

//    void update(Blog blog);

    void remove(Integer id);
}
