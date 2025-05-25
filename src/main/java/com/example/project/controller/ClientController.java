package com.example.project.controller;

import com.example.project.dto.ClientDTO;
import com.example.project.entity.Client;
import com.example.project.repository.ClientRepository;
import com.example.project.serviceImpli.ClientServiceImpli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientServiceImpli clientService;

    @PostMapping("/save")
    public Client create(@RequestBody ClientDTO clientDto) {
        return clientService.create(clientDto);
    }

    @GetMapping("list")
    public List<ClientDTO> getList() {
        return clientService.getList();
    }

    @GetMapping("/get")
    public Client getById(@RequestParam Long id) {
        return clientService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Client updateById(@RequestParam Long id, @RequestBody ClientDTO clientDto) {
        return clientService.updateById(id , clientDto);
    }

     @DeleteMapping("/delete")
     public String deleteById(@RequestParam Long id) {
       return  clientService.deleteById(id);
    }

}
