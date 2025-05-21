package com.example.project.dto;

import com.example.project.entity.Client;
import com.example.project.entity.Employee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class AddressDTO {

    private Long id;

    private String address;

    private String state;

    private String city;

    private String pincode;


}
