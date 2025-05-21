package com.example.project.dto;

import com.example.project.entity.Address;
import com.example.project.entity.Employee;
import com.example.project.entity.Project;
import com.example.project.entity.Task;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class ProjectDTO {


    private Long id;

    private String name;

    private String description;

    private LocalDate projectStartDate;

    private LocalDate projectEndDate;

    private String status;

    private List<EmployeeDTO> employeeDto;

    private List<TaskDTO> taskDto;
}
