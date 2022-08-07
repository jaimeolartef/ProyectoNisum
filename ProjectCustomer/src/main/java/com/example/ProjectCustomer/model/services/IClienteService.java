package com.example.ProjectCustomer.model.services;

import com.example.ProjectCustomer.model.entity.Cliente;

import java.util.List;

public interface IClienteService {

    Cliente findByIdCliente(Integer idCliente);

    List<Cliente> findAll();

    Cliente save(Cliente cliente);

    void delete(Integer idCliente);
}
