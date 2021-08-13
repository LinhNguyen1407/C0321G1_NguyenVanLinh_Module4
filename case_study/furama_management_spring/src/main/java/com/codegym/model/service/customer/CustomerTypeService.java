package com.codegym.model.service.customer;

import com.codegym.model.entity.customer.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();
}
