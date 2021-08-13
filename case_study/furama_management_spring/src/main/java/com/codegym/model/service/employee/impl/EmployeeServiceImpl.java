package com.codegym.model.service.employee.impl;

import com.codegym.model.entity.employee.Employee;
import com.codegym.model.repository.employee.EmployeeRepository;
import com.codegym.model.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAllByFlagDel() {
        return employeeRepository.findAllByFlagDel();
    }

    @Override
    public Page<Employee> findAllByFlagDel(Pageable pageable) {
        return employeeRepository.findAllByFlagDel(pageable);
    }

    @Override
    public Page<Employee> searchByNameAndIdCard(String name, String idCard, Pageable pageable) {
        return employeeRepository.searchByNameAndIdCard(name, idCard, pageable);
    }
}
