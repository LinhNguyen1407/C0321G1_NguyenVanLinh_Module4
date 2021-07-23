package com.codegym.customer_managemet_spring_boot.model.service;

import com.codegym.customer_managemet_spring_boot.model.bean.Customer;
import com.codegym.customer_managemet_spring_boot.model.bean.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {

    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

}
