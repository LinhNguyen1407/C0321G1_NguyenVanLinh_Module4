package com.codegym.model.repository.employee;

import com.codegym.model.entity.employee.User;
import com.codegym.model.entity.employee.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUser(User user);
}
