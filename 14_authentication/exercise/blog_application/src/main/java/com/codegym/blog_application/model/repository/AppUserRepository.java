package com.codegym.blog_application.model.repository;

import com.codegym.blog_application.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String userNam);
}
