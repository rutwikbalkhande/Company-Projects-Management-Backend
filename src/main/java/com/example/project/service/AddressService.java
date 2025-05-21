package com.example.project.service;

import com.example.project.dto.AddressDTO;

import java.util.List;

public interface AddressService {

   AddressDTO create(AddressDTO addressDto);

   List<AddressDTO> getList();
   
   AddressDTO getByid(Long id);
}
