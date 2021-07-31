package com.codegym.model.repository;

import com.codegym.model.entity.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneRepository extends CrudRepository<Smartphone, Long> {
}
