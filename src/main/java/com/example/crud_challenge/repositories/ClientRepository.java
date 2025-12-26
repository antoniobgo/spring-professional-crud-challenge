package com.example.crud_challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud_challenge.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
