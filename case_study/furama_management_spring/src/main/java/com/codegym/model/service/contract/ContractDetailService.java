package com.codegym.model.service.contract;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractDetailService {

    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    Page<ContractDetail> findAll(Pageable pageable);

    Page<ContractDetail> findCustomerByStatus(Pageable pageable);

    List<ContractDetail> findCustomerByStatus();

    void calculateTotalMoney();
}
