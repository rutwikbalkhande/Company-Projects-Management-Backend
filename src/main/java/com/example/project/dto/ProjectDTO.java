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
public class ProjectDTO {


    private Long id;

    private String name;

    private String description;

    private LocalDate projectStartDate;

    private LocalDate projectEndDate;

    private String status;

    private List<EmployeeDTO> employeeDto;

    private List<TaskDTO> taskDto;

    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.description = project.getDescription();
        this.projectStartDate = project.getProjectStartDate();
        this.projectEndDate = project.getProjectEndDate();
        this.status = project.getStatus();



        if (project.getEmployee() != null) {
            this.employeeDto = project.getEmployee().stream()
                    .map(EmployeeDTO::new)
                    .collect(Collectors.toList());
        }

        if (project.getTask() != null) {
            this.taskDto = project.getTask().stream()
                    .map(TaskDTO::new)
                    .collect(Collectors.toList());
        }
    }
}
