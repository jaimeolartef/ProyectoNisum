package com.example.ProjectCustomer.controller;

import com.example.ProjectCustomer.model.entity.Cliente;
import com.example.ProjectCustomer.model.entity.Telefono;
import com.example.ProjectCustomer.model.services.IClienteService;
import com.example.ProjectCustomer.model.services.ITelefonoService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private ITelefonoService telefonoService;

    public List<Cliente> clientes() {
        /*clienteService.findAll().forEach(cliente -> {
            cliente.setTipoDocumento(tipoDocumentoService.findByIdTipoDocumento(cliente.getIdTipoDocumento()));
        });*/
        return clienteService.findAll();
    }

    public ResponseEntity<String> guardar(Cliente cliente) {
        ResponseEntity<String> responseEntity;

        if (!validacion(cliente)) {
            responseEntity = new ResponseEntity<String>("Error paramatros invalidos.",
                    HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            Cliente clienteGuardado = clienteService.save(cliente);
            cliente.getPhones().forEach(telefono -> {
                telefonoService.save(telefono);
            });
            if ((Objects.nonNull(clienteGuardado) && Objects.nonNull(clienteGuardado.getId()))) {
                responseEntity = new ResponseEntity<String>("El cliente se guardo correctamente",
                        HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<String>("Error al guardar el cliente",
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return responseEntity;
    }

    private boolean validacion(Cliente cliente) {
        boolean validacion = true;
        boolean correo = false;

        String regx = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(cliente.getEmail());


        if (Objects.isNull(cliente)) {
            validacion = false;
        } else if (Strings.isBlank(cliente.getEmail())
                || Strings.isBlank(cliente.getName())
                || Strings.isBlank(cliente.getPassword())) {
            validacion = false;
        } else if (!matcher.matches()){
            validacion = false;
        }

        return validacion;
    }

    public ResponseEntity<String> eliminar(Integer idCliente) {
        ResponseEntity<String> responseEntity;

        try {
            clienteService.delete(idCliente);
            responseEntity = new ResponseEntity<String>("El cliente se elimino correctamente",
                    HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>("Error al eliminar el cliente",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
