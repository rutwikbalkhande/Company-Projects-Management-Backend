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

    private AddressDTO addressDto;           // Good (uses another DTO)

    private List<TaskDTO> taskDto;

    private Long projectId;
    private Long clientId;// Good (uses DTOs)

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
            this.projectDto = new ProjectDTO(employee.getProject());
        }

        if (employee.getAddress() != null) {
            this.addressDto = new AddressDTO(employee.getAddress());
        }

        if (employee.getClient() != null)
            this.clientId = employee.getClient().getId();

        if (employee.getTasks() != null) {
            this.taskDto = employee.getTasks().stream()
                    .map(TaskDTO::new)
                    .collect(Collectors.toList());
        }
    }

}
