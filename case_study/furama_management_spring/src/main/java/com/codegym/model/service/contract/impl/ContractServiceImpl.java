package com.codegym.model.service.contract.impl;


import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract.ContractDetail;
import com.codegym.model.repository.contract.ContractDetailRepository;
import com.codegym.model.repository.contract.ContractRepository;
import com.codegym.model.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void calculateTotalMoney() {
        List<ContractDetail> contractDetails = contractDetailRepository.findAll();
        List<Contract> contracts = contractRepository.findAll();

        for (Contract contract : contracts) {
            long totalMoney = contract.getService().getCost();
            for (ContractDetail c : contractDetails) {
                if (c.getContract().equals(contract)) {
                    totalMoney += c.getQuantity() * c.getAttachService().getCost();
                }
            }
            contract.setTotalMoney(totalMoney);
            contractRepository.save(contract);
        }
    }
}
