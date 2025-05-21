package com.example.project.dto;

import com.example.project.entity.Employee;
import com.example.project.entity.Project;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDTO {

    private Long id;

    private String name;

    private String description;

    private LocalDate deadline;

    private String responsibility;

    private String status;

    private EmployeeDTO employeeDto;

    private ProjectDTO projectDto;

}
