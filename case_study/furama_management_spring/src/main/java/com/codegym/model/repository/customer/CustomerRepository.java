package com.codegym.model.repository.customer;

import com.codegym.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByFlagDelEquals(int flagDel);

    Page<Customer> findAllByFlagDelEquals (int flagDel, Pageable pageable);

    Page<Customer> findAllByNameContainingOrAddressContaining (String name, String address, Pageable pageable);

}
