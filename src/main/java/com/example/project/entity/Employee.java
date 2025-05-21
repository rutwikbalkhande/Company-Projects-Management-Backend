package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     private String name;

     private String email;

     private String phone;

     private String role;

     private String asset;

     private Double salary;

     private LocalDate joiningDate;

     @OneToOne( cascade = CascadeType.ALL)
     @JoinColumn(name = "address_id")
     private Address address;

     @ManyToOne
     @JoinColumn(name = "project_id")
     private Project project;

     @OneToMany(mappedBy = "employee")
     private List<Task> tasks;

     @ManyToOne
     @JoinColumn(name = "client_id")
     private Client client;








}
