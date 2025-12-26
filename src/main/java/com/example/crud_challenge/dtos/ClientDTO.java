package com.example.crud_challenge.dtos;

import java.time.LocalDate;

import com.example.crud_challenge.entities.Client;

public class ClientDTO {

    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private LocalDate localDate;
    private int children;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate localDate, int children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.localDate = localDate;
        this.children = children;
    }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.income = client.getIncome();
        this.localDate = client.getLocalDate();
        this.children = client.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public int getChildren() {
        return children;
    }

}
