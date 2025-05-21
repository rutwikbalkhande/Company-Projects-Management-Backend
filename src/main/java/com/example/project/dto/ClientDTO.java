package com.example.project.dto;

import com.example.project.entity.Address;
import com.example.project.entity.Employee;
import com.example.project.entity.Project;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ClientDTO {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private LocalDate contractStartDate;

    private LocalDate contractEndDate;


    private AddressDTO addressDto;

    private List<EmployeeDTO> employeeDto;

    private List<ProjectDTO> projectDto;

}
