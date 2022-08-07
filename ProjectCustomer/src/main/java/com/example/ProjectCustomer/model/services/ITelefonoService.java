package com.example.ProjectCustomer.model.services;

import com.example.ProjectCustomer.model.entity.Telefono;

public interface ITelefonoService {

    Telefono findById(Integer id);

    Telefono save(Telefono telefono);
}
