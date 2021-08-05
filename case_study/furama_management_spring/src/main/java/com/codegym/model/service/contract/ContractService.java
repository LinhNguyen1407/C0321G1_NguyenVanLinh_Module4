package com.codegym.model.service.contract;

import com.codegym.model.entity.contract.Contract;
import java.util.List;

public interface ContractService {

    List<Contract> findAll();

    void save(Contract contract);
}
