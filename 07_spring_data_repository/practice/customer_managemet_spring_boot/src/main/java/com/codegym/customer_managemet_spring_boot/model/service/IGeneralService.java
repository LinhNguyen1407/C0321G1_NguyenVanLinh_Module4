package com.codegym.customer_managemet_spring_boot.model.service;

import com.codegym.customer_managemet_spring_boot.model.bean.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}
