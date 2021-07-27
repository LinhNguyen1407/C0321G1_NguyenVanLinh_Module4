package com.codegym.model.service;

import com.codegym.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Integer id);

    void save(Book book);
}
