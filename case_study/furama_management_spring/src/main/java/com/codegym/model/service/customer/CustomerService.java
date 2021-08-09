package com.codegym.model.service.customer;

import com.codegym.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void delete(Customer customer);

    Page<Customer> findAllByFlagDelEquals (int flagDel, Pageable pageable);

    Page<Customer> findAllByNameContainingOrAddressContaining (String name, String address, Pageable pageable);

    List<Customer> findAllByFlagDelEquals(int flagDel);
}
