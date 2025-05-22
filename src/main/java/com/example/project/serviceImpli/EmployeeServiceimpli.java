package com.example.project.serviceImpli;

import com.example.project.dto.EmployeeDTO;
import com.example.project.entity.Employee;
import com.example.project.repository.EmployeeRepository;
import com.example.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceimpli implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public Employee create( EmployeeDTO employeeDto) {
        Employee employee=new Employee();

        employee.setName( employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhone(employeeDto.getPhone());
        employee.setRole(employeeDto.getRole());
        employee.setAsset(employeeDto.getAsset());
        employee.setJoiningDate(employeeDto.getJoiningDate());

        return employeeRepo.save(employee);
    }

    @Override
    public List<EmployeeDTO> getList() {
        return employeeRepo.findAll().stream().map(EmployeeDTO :: new).collect(Collectors.toList());
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("employee not found with id: "+ id)) ;
    }

    @Override
    public Employee updateById(Long id, EmployeeDTO employeeDto) {

       return employeeRepo.findById(id).map(emp ->{

            emp.setName(employeeDto.getName());
            emp.setEmail(employeeDto.getEmail());
            emp.setPhone(employeeDto.getPhone());
            emp.setRole(employeeDto.getRole());
            emp.setAsset(employeeDto.getAsset());

            return  employeeRepo.save(emp);
        }) .orElseThrow(() -> new RuntimeException("employee not found with id: "+ id)) ;


    }

    @Override
    public String deleteById(Long id) {

        employeeRepo.findById(id).orElseThrow();
        employeeRepo.deleteById(id);
        return "employee delete successfully using id:"+ id;
    }
}
