package com.codegym.customer_managemet_spring_boot.model.repository;

import com.codegym.customer_managemet_spring_boot.model.bean.Customer;
import com.codegym.customer_managemet_spring_boot.model.bean.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}

