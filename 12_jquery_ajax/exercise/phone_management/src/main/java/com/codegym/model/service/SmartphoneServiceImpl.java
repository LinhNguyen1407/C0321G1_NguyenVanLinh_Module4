package com.codegym.model.service;

import com.codegym.model.entity.Smartphone;
import com.codegym.model.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {

    @Autowired
    private SmartphoneRepository smartPhoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }
}