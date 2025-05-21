package com.example.project.service;

import com.example.project.dto.ClientDTO;
import com.example.project.entity.Client;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClientService {

  ClientDTO create(ClientDTO clientDto);

  List<ClientDTO> getList();

  ClientDTO getByid(Long id);


}
