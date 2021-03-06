package com.codegym.model.service.employee;


import com.codegym.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    void save(Employee employee);

    void delete(Employee employee);

    Page<Employee> findAll(Pageable pageable);

    List<Employee> findAllByFlagDel();

    Page<Employee> findAllByFlagDel(Pageable pageable);

    Page<Employee> searchByNameAndIdCard(String name, String idCard, Pageable pageable);

}
