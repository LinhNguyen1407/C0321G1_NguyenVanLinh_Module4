package com.codegym.model.service.contract;

import com.codegym.model.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {

    List<Contract> findAll();

    void save(Contract contract);

    Page<Contract> findAll(Pageable pageable);

    void calculateTotalMoney();

}
