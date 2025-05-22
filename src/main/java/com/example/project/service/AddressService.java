package com.example.project.service;

import com.example.project.dto.AddressDTO;
import com.example.project.entity.Address;

import java.util.List;

public interface AddressService {

   Address create(AddressDTO addressDto);

   List<AddressDTO> getList();
   
   Address getById(Long id);

   Address updateById(Long id, AddressDTO addressDto);

   String deleteById(Long id);
}
