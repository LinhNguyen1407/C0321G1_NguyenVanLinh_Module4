package com.codegym.model.service.service.impl;

import com.codegym.model.entity.service.AttachService;
import com.codegym.model.repository.service.AttachServiceRepository;
import com.codegym.model.service.service.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements AttachServiceService {

    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
