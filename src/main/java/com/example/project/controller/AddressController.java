package com.example.project.controller;

import com.example.project.dto.AddressDTO;
import com.example.project.entity.Address;
import com.example.project.serviceImpli.AddressServiceImpli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/address")
public class AddressController {

    @Autowired
    private AddressServiceImpli addressServiceimpli;

    @PostMapping("/save")
    public Address create(@RequestBody AddressDTO addressDto) {

        return addressServiceimpli.create(addressDto) ;
    }

@GetMapping("/list")
    public List<AddressDTO> getAll() {
        return addressServiceimpli.getList() ;
    }

@GetMapping("/get")
    public Address getById(@RequestParam  Long id) {
        return addressServiceimpli.getById(id);
    }

@PutMapping("/update")
    public Address updateById(@RequestParam Long id,@RequestBody AddressDTO addressDto) {
        return addressServiceimpli.updateById(id, addressDto);
    }

@DeleteMapping("/delete")
    public String deleteById(@RequestParam Long id) {
     return addressServiceimpli.deleteById(id);
    }

}
