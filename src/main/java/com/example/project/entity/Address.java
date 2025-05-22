package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String state;

    private String city;

    private String pincode;

    @OneToOne(mappedBy = "address" , cascade = CascadeType.ALL)
    private Employee employee;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Client client;


}
