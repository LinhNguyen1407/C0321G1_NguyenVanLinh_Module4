package com.codegym.model.service.employee.impl;

import com.codegym.model.entity.employee.Division;
import com.codegym.model.repository.employee.DivisionRepository;
import com.codegym.model.service.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
