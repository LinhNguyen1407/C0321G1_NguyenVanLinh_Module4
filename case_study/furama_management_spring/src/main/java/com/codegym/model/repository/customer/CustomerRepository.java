package com.codegym.model.repository.customer;

import com.codegym.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select * from customer " +
            "where flag_del = 0", nativeQuery = true)
    List<Customer> findAllByFlagDel();

    @Query(value = "select * from customer " +
            "where flag_del = 0", nativeQuery = true)
    Page<Customer> findAllByFlagDel(Pageable pageable);

    @Query(value = "select * from customer " +
            "where flag_del = 0 and concat(`name`, id_card) like %:keyword%", nativeQuery = true)
    Page<Customer> findAllByNameOrAddress(@Param("keyword") String keywordValue, Pageable pageable);

}
