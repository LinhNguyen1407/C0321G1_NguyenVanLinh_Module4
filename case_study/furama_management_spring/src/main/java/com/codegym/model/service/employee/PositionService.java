package com.codegym.model.service.employee;

import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.employee.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();
}
