package com.codegym.model.repository.service;

import com.codegym.model.entity.service.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachServiceRepository extends JpaRepository<AttachService, Long> {
}
