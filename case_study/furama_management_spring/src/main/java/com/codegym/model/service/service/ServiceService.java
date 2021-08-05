package com.codegym.model.service.service;

import com.codegym.model.entity.service.Service;
import java.util.List;

public interface ServiceService {

    List<Service> findAll();

    void save(Service service);

}
