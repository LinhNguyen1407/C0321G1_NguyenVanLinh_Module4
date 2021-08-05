package com.codegym.model.service.employee;


import com.codegym.model.entity.employee.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    void save(Employee employee);

    void delete(Employee employee);

}
