package com.codegym.model.service.customer.impl;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.repository.customer.CustomerRepository;
import com.codegym.model.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Page<Customer> findAllByFlagDel(Pageable pageable) {
        return customerRepository.findAllByFlagDel(pageable);
    }

    @Override
    public Page<Customer> findAllByNameOrAddress(String keyword, Pageable pageable) {
        return customerRepository.findAllByNameOrAddress(keyword, pageable);
    }

    @Override
    public List<Customer> findAllByFlagDel() {
        return customerRepository.findAllByFlagDel();
    }

}
