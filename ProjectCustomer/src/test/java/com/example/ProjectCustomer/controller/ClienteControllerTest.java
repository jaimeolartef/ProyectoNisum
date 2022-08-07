package com.example.ProjectCustomer.controller;

import com.example.ProjectCustomer.model.entity.Cliente;
import com.example.ProjectCustomer.model.entity.Telefono;
import com.example.ProjectCustomer.model.services.IClienteService;
import com.example.ProjectCustomer.model.services.ITelefonoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class ClienteControllerTest {

    @Mock
    private IClienteService clienteService;

    @Mock
    private ITelefonoService telefonoService;

    @InjectMocks
    private ClienteController clienteController;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        List<Telefono> telefonos = new ArrayList<>();
        Telefono telefono = new Telefono();
        telefono.setId(1);
        telefono.setCityCode("prueba");
        telefono.setNumber("123456");
        telefono.setCountryCode("57");
        telefonos.add(telefono);

        cliente = new Cliente();
        cliente.setId(1);
        cliente.setEmail("jaimeolartef@gmail.com");
        cliente.setPassword("12345678");
        cliente.setName("cliente test unit");
        cliente.setPhones(telefonos);
    }

    @Test
    void whenFindAllClinetesThenListCliente() {
        when(clienteService.findAll()).thenReturn(Arrays.asList(cliente));
        assertNotNull(clienteController.clientes());
    }

    @Test
    void givenClienteWhenGuardarThenResponseHttpOk() {
        when(clienteService.save(any(Cliente.class))).thenReturn(cliente);
        assertEquals(clienteController.guardar(cliente), new ResponseEntity<String>("El cliente se guardo correctamente",
                HttpStatus.OK));
    }

    @Test
    void givenIdClienteWhenEliminarThenVoid() {
        clienteService.delete(anyInt());
        assertEquals(clienteController.eliminar(anyInt()), new ResponseEntity<String>("El cliente se elimino correctamente",
                HttpStatus.OK));
    }
}