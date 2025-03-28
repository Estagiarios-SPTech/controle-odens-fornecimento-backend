package com.stefanini.controle_de_ofs.controllers;

import com.stefanini.controle_de_ofs.models.Employee;
import com.stefanini.controle_de_ofs.repository.RepositoryEmployee;
import com.stefanini.controle_de_ofs.services.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private RepositoryEmployee action;

    @Autowired
    private ServiceEmployee serviceEmployee;

//    @PostMapping("/listaColaboradores")
//    public ResponseEntity<?>
}
