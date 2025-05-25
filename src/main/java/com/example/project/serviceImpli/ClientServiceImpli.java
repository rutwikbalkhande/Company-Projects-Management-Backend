package com.example.project.serviceImpli;

import com.example.project.dto.AddressDTO;
import com.example.project.dto.ClientDTO;
import com.example.project.entity.Address;
import com.example.project.entity.Client;
import com.example.project.repository.AddressRepository;
import com.example.project.repository.ClientRepository;
import com.example.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpli implements ClientService {

    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private AddressRepository addressRepo;

    @Override
    public Client create(ClientDTO clientDto) {

        Client client = new Client();

        client.setName( clientDto.getName());
        client.setEmail( clientDto.getEmail() );
        client.setPhone( clientDto.getPhone() );
        client.setContractStartDate( clientDto.getContractStartDate());
        client.setContractEndDate( clientDto.getContractEndDate());

          //set AddressId in client table
       Address address= addressRepo.findById(clientDto.getAddressId()).orElseThrow();

       client.setAddress(address);

        return clientRepo.save(client);
    }

    @Override
    public List<ClientDTO> getList() {

        return clientRepo.findAll(). stream().map(ClientDTO :: new).toList();
    }

    @Override
    public Client getById(Long id) {
        return clientRepo.findById(id).orElseThrow(() -> new RuntimeException("client not found")) ;
    }

    @Override
    public Client updateById(Long id, ClientDTO clientDto) {

        return clientRepo.findById(id).map(client -> {

           client.setName (clientDto.getName());
           client.setEmail(clientDto.getEmail());
           client.setPhone(clientDto.getPhone());
           client.setContractStartDate(clientDto.getContractStartDate());
           client.setContractEndDate(clientDto.getContractEndDate());

           if(clientDto.getAddressId() !=null)
           {
              Address address = addressRepo.findById(clientDto.getAddressId()) .orElseThrow();
              client.setAddress(address);
           }


            return clientRepo.save(client);
        }) .orElseThrow(() -> new RuntimeException("client not found"));

    }

    @Override
    public String deleteById(Long id) {

       Client client = clientRepo.findById(id).orElseThrow( () -> new RuntimeException(" id not found: "));

        clientRepo.delete(client);

        return "record delete successfully";

    }
}
