package com.example.ProjectCustomer.model.dao;

import com.example.ProjectCustomer.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Integer> {
}
