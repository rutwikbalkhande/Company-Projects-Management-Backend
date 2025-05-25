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
/*   postman data........
    employee create
    {
  "name": "rutwik",
  "email": "rutwik@gmail.com",
  "role": "Java Developer",
  "phone": "245889658",
  "asset": "laptop",
  "salary": 25000.00,
  "joiningDate": "2025-05-12",
  "addressDto": {
    "address": "Karve Nagar",
    "state": "Maharashtra",
    "city": "Pune",
    "pincode": "984845"
  },
  "projectId"=1,
  "client":1,
  "addressId": 1
}

     */