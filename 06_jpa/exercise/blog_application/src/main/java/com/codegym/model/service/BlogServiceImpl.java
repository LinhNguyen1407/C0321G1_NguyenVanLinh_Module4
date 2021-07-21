package com.codegym.model.service;

import com.codegym.model.bean.Blog;
import com.codegym.model.repository.BaseRepository;
import com.codegym.model.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository repository;

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return repository.findById(id);
    }

//    @Override
//    public void update(Blog blog) {
//        repository.update(blog);
//    }

    @Override
    public void remove(Integer id) {
        repository.remove(id);
    }
}
