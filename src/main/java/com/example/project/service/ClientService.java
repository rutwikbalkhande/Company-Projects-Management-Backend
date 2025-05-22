package com.example.project.service;

import com.example.project.dto.ClientDTO;
import com.example.project.entity.Client;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClientService {

  Client create(ClientDTO clientDto);

  List<ClientDTO> getList();

  Client getById(Long id);

  Client updateById(Long id, ClientDTO clientDto);

  String deleteById(Long id);

}
