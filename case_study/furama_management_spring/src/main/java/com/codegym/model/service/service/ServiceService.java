package com.codegym.model.service.service;

import com.codegym.model.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ServiceService {

    List<Service> findAll();

    Page<Service> findAll(Pageable pageable);

    void save(Service service);

    Optional<Service> findById(Long id);

}
