package com.example.project.dto;

import com.example.project.entity.Address;
import com.example.project.entity.Client;
import com.example.project.entity.Employee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long id;

    private String address;

    private String state;

    private String city;

    private String pincode;

    //constructor
    public AddressDTO(Address address) {
        this.id = address.getId();
        this.address = address.getAddress();
        this.state = address.getState();
        this.city = address.getCity();
        this.pincode = address.getPincode();
    }


}
