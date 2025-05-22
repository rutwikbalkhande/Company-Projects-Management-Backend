package com.example.project.serviceImpli;

import com.example.project.dto.AddressDTO;
import com.example.project.entity.Address;
import com.example.project.repository.AddressRepository;
import com.example.project.service.AddressService;
import com.example.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AddressServiceImpli implements AddressService {

    @Autowired
    private AddressRepository addressRepo;

    @Override
    public Address create(AddressDTO addressDto) {

        Address address = new Address();

        address.setAddress (addressDto.getAddress()) ;
        address.setState (addressDto.getState());
        address.setCity (addressDto.getCity());
        address.setPincode (addressDto.getPincode());

        return addressRepo.save(address);
    }

    @Override
    public List<AddressDTO> getList() {

         return addressRepo.findAll().stream().map(AddressDTO :: new).toList();

    }

    @Override
    public Address getById(Long id) {

        return addressRepo.findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }

    @Override
    public Address updateById(Long id, AddressDTO addressDto) {

        return addressRepo.findById(id).map( address -> {
            address.setState( addressDto.getState());
            address.setCity(addressDto.getCity());
            address.setAddress(addressDto.getAddress());
            address.setPincode(addressDto.getPincode());

            return addressRepo.save(address);
                } ).orElseThrow(()-> new RuntimeException("not found"));
    }

    @Override
    public String deleteById(Long id) {

        addressRepo.findById(id).orElseThrow(()-> new RuntimeException("user not found id: "+ id));

        addressRepo.deleteById(id);

        return "user delete successfully";
    }


}
