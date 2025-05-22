package com.example.project.dto;

import com.example.project.entity.Address;
import com.example.project.entity.Client;
import com.example.project.entity.Employee;
import com.example.project.entity.Project;
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

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        this.phone = client.getPhone();
        this.contractStartDate = client.getContractStartDate();
        this.contractEndDate = client.getContractEndDate();

        if (client.getAddress() != null) {                    //storing client address
            this.addressDto = new AddressDTO(client.getAddress());
        }

        if (client.getEmployee() != null) {            // fetching employee details from client
            this.employeeDto = client.getEmployee().stream()
                    .map(EmployeeDTO::new)
                    .collect(Collectors.toList());
        }

        if (client.getProject() != null) {              //fetching project details by client
            this.projectDto = client.getProject().stream()
                    .map(ProjectDTO::new)
                    .collect(Collectors.toList());
        }


    }


}
