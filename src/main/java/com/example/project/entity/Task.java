package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDate deadline;

    private String responsibility;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @ManyToOne
    private Project project;


}
//postman data
/*
{

        "name": "abhi",
        "description": "remove bugs",
        "deadline": "2027-08-01",
        "responsibility": "tester",
        "status": "ongoining",
        "employeeId": 1,
        "projectId": 2
    }
 */