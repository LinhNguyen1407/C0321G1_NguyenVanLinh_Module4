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
    public Page<Customer> findAllByFlagDelEquals(int flagDel, Pageable pageable) {
        return customerRepository.findAllByFlagDelEquals(flagDel, pageable);
    }

    @Override
    public Page<Customer> findAllByNameContainingOrAddressContaining(String name, String address, Pageable pageable) {
        return customerRepository.findAllByNameContainingOrAddressContaining(name, address, pageable);
    }

    @Override
    public List<Customer> findAllByFlagDelEquals(int flagDel) {
        return customerRepository.findAllByFlagDelEquals(flagDel);
    }

}
