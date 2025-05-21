package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDate projectStartDate;

    private LocalDate projectEndDate;

    private String status;

    @OneToMany(mappedBy = "project")
    private List<Employee> employee;

    @OneToMany(mappedBy = "project")
    private List<Task> task;

    @ManyToOne
    private Client client;

}
