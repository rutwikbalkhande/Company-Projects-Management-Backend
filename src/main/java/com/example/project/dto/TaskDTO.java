package com.example.project.dto;

import com.example.project.entity.Employee;
import com.example.project.entity.Project;
import com.example.project.entity.Task;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Long id;

    private String name;

    private String description;

    private LocalDate deadline;

    private String responsibility;

    private String status;
/*
    private EmployeeDTO employeeDto;
    private ProjectDTO projectDto;
*/
    private Long employeeId;
    private Long projectId;


    //constructor crating

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.description = task.getDescription();
        this.deadline = task.getDeadline();
        this.responsibility = task.getResponsibility();
        this.status = task.getStatus();


        if (task.getEmployee() != null) {
            this.employeeId = (task.getEmployee().getId());
        }

        if (task.getProject() != null) {
            this.projectId = task.getProject().getId();
        }


    }


}
