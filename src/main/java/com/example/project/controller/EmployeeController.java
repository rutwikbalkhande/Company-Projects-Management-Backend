package com.example.project.controller;


import com.example.project.dto.EmployeeDTO;
import com.example.project.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @PostMapping("/create")
    public Employee create(@RequestBody EmployeeDTO employeeDto) {
        return null;
    }

    @GetMapping("/list")
    public List<EmployeeDTO> getList() {
        return List.of();
    }

    @GetMapping("/get-id")
    public Employee getById(@RequestParam Long id) {
        return null;
    }

    @PutMapping("/update-id")
    public Employee updateById(@RequestParam Long id,@RequestBody EmployeeDTO employeeDto) {
        return null;
    }

    @DeleteMapping("/delete-id")
    public void deleteById(Long id) {

    }

}
