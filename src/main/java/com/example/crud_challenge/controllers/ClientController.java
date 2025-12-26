package com.example.crud_challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_challenge.dtos.ClientDTO;
import com.example.crud_challenge.services.ClientService;

@RestController
@RequestMapping(path="/clients")
public class ClientController {

    @Autowired
    private ClientService  service;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        ClientDTO clientDTO = service.findById(id);
        return ResponseEntity.ok(clientDTO);
    }
}
