package com.codegym.model.service.service.impl;

import com.codegym.model.entity.service.ServiceType;
import com.codegym.model.repository.service.ServiceTypeRepository;
import com.codegym.model.service.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeImpl implements ServiceTypeService {

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
