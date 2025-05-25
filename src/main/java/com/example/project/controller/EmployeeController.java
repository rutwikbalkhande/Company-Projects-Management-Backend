package com.example.project.controller;


import com.example.project.dto.EmployeeDTO;
import com.example.project.entity.Employee;
import com.example.project.serviceImpli.EmployeeServiceImpli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpli employeeRepo;

    @PostMapping("/save")
    public Employee create(@RequestBody EmployeeDTO employeeDto) {

        return employeeRepo.create(employeeDto);
    }

    @GetMapping("/list")
    public List<EmployeeDTO> getList() {

        return employeeRepo.getList();
    }

    @GetMapping("/get")
    public Employee getById(@RequestParam Long id) {

        return employeeRepo.getById(id);
    }

    @PutMapping("/update")
    public Employee updateById(@RequestParam Long id,@RequestBody EmployeeDTO employeeDto) {
        return employeeRepo.updateById(id, employeeDto);
    }

    @DeleteMapping("/delete")
    public String deleteById(Long id) {

        employeeRepo.deleteById(id);
        return "";
    }

}
