package com.codegym.model.service.service.impl;

import com.codegym.model.entity.service.RentType;
import com.codegym.model.repository.service.RentTypeRepository;
import com.codegym.model.service.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {

    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
