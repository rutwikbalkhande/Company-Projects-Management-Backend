package com.example.project.dto;

import com.example.project.entity.Address;
import com.example.project.entity.Project;
import com.example.project.entity.Task;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class EmployeeDTO {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String role;

    private String asset;

    private Double salary;

    private LocalDate joiningDate;

    private ProjectDTO projectDto;

    private AddressDTO addressDto;           // Good (uses another DTO)

    private List<TaskDTO> taskDto;          // Good (uses DTOs)


}
