package com.example.crud_challenge.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.crud_challenge.dtos.ClientDTO;
import com.example.crud_challenge.services.ClientService;

import jakarta.validation.Valid;

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

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@RequestBody @Valid ClientDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(dto.getId())
                    .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody @Valid ClientDTO dto) {
        ClientDTO clientDTO = service.update(id, dto);
        return ResponseEntity.ok(clientDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
