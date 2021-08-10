package com.codegym.model.repository.contract;

import com.codegym.model.entity.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail, Long> {

    @Query("select ctdt\n" +
            "from Contract ct\n" +
            "join ContractDetail ctdt on ctdt.contract.id = ct.id\n" +
            "where current_date < ct.endDate\n" +
            "order by ct.id")
    Page<ContractDetail> findCustomerByStatus(Pageable pageable);

    @Query("select ctdt\n" +
            "from Contract ct\n" +
            "join ContractDetail ctdt on ctdt.contract.id = ct.id\n" +
            "where current_date < ct.endDate\n")
    List<ContractDetail> findCustomerByStatus();
}
