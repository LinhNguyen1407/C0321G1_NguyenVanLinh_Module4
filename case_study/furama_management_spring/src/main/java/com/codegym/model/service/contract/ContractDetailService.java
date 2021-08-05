package com.codegym.model.service.contract;

import com.codegym.model.entity.contract.ContractDetail;
import java.util.List;

public interface ContractDetailService {

    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);
}
