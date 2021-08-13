package com.codegym.model.service.contract;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ContractDetailService {

    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    Page<ContractDetail> findAll(Pageable pageable);

    Optional<ContractDetail> findById(Long id);

    Page<ContractDetail> findCustomerByStatus(Pageable pageable);

}
