package com.codegym.model.repository.employee;

import com.codegym.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByFlagDelEquals(int flagDel);

    Page<Employee> findAllByFlagDelEquals (int flagDel, Pageable pageable);

}
