package com.example.project.service;

import com.example.project.dto.EmployeeDTO;
import com.example.project.entity.Employee;

import java.util.List;

public interface EmployeeService {

      Employee create(EmployeeDTO employeeDto);

      List<EmployeeDTO> getList();

      Employee getById(Long id);

      Employee updateById(Long id, EmployeeDTO employeeDto);

      String deleteById(Long id);

}
