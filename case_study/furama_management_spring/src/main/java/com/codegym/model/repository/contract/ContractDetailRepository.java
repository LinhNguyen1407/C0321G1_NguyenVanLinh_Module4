package com.codegym.model.repository.contract;

import com.codegym.model.entity.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail, Long> {

//    @Query("select ctdt\n" +
//            "from Customer cm\n" +
//            "join Contract ct on ct.customer.id = cm.id\n" +
//            "join Service sv on sv.id = ct.service.id\n" +
//            "join ContractDetail ctdt on ctdt.contract.id = ct.id\n" +
//            "join AttachService atsv on atsv.id = ctdt.attachService.id\n" +
//            "where current_date < ct.endDate\n" +
//            "order by cm.id")
    @Query("select ctdt\n" +
            "from Contract ct\n" +
            "join ContractDetail ctdt on ctdt.contract.id = ct.id\n" +
            "where current_date < ct.endDate\n" +
            "order by ctdt.id")
    Page<ContractDetail> findCustomerByStatus(Pageable pageable);
}
