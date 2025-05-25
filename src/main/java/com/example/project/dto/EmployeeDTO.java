package com.example.project.dto;

import com.example.project.entity.Address;
import com.example.project.entity.Employee;
import com.example.project.entity.Project;
import com.example.project.entity.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String role;

    private String asset;

    private Double salary;

    private LocalDate joiningDate;

    private ProjectDTO projectDto;

    private AddressDTO addressDto;

    private List<TaskDTO> taskDto;

    // Just keep related entity IDs to avoid deep recursion
    private Long projectId;
    private Long clientId;
    private Long addressId;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.email = employee.getEmail();
        this.phone = employee.getPhone();
        this.role = employee.getRole();
        this.asset = employee.getAsset();
        this.salary = employee.getSalary();
        this.joiningDate = employee.getJoiningDate();

        if (employee.getProject() != null) {
            this.projectId = employee.getProject().getId();
        }
        if (employee.getClient() != null) {
            this.clientId = employee.getClient().getId();
        }
        if (employee.getAddress() != null) {
            this.addressId = employee.getAddress().getId();
        }
    }

}
