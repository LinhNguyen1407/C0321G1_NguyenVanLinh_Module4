package com.codegym.model.service.employee.impl;

import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.repository.employee.EducationDegreeRepository;
import com.codegym.model.service.employee.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {

    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
