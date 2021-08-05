package com.codegym.model.service.service.impl;

import com.codegym.model.entity.service.Service;
import com.codegym.model.repository.service.ServiceRepository;
import com.codegym.model.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }
}
