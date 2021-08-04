package com.codegym.blog_application.model.repository;

import com.codegym.blog_application.model.entity.AppUser;
import com.codegym.blog_application.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findByAppUser(AppUser appUser);
}
