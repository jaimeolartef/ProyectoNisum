package com.example.ProjectCustomer.model.services;

import com.example.ProjectCustomer.model.dao.ITelefonoDao;
import com.example.ProjectCustomer.model.entity.Telefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefonoServiceImpl implements ITelefonoService {

    @Autowired
    private ITelefonoDao telefonoDao;

    @Override
    public Telefono findById(Integer id) {
        return telefonoDao.findById(id).get();
    }

    @Override
    public Telefono save(Telefono telefono) {
        return telefonoDao.save(telefono);
    }
}
