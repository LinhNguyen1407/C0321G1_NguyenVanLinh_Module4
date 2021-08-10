package com.codegym.model.service.contract.impl;


import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract.ContractDetail;
import com.codegym.model.repository.contract.ContractDetailRepository;
import com.codegym.model.repository.contract.ContractRepository;
import com.codegym.model.service.contract.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {

    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public Page<ContractDetail> findCustomerByStatus(Pageable pageable) {
        return contractDetailRepository.findCustomerByStatus(pageable);
    }

    @Override
    public List<ContractDetail> findCustomerByStatus() {
        return contractDetailRepository.findCustomerByStatus();
    }

    @Override
    public void calculateTotalMoney() {
        List<ContractDetail> contractDetails = contractDetailRepository.findCustomerByStatus();
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
