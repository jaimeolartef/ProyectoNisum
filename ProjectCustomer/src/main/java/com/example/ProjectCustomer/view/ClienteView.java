package com.example.ProjectCustomer.view;

import com.example.ProjectCustomer.controller.ClienteController;
import com.example.ProjectCustomer.model.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
public class ClienteView {

    @Autowired
    private ClienteController clienteController;

    @GetMapping("/clientes")
    public List<Cliente> clientes() {
        return clienteController.clientes();
    }

    @PostMapping("/guardar-cliente")
    public ResponseEntity<String> guardar(@RequestBody Cliente cliente) {
        return clienteController.guardar(cliente);
    }

    @DeleteMapping("/eliminar-cliente/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable(value = "id") Integer idCliente) {
        return clienteController.eliminar(idCliente);
    }

}
