package com.example.crud_challenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud_challenge.entities.Client;
import com.example.crud_challenge.dtos.ClientDTO;
import com.example.crud_challenge.repositories.ClientRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        // Client client = repository.findById(id).orElseThrow(
        //         () -> new Exception("Resource not found"));
        Client client = repository.findById(id).get();
        return new ClientDTO(client);
    }

}
