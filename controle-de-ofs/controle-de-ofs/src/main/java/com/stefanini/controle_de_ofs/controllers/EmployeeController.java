package com.stefanini.controle_de_ofs.controllers;

import com.stefanini.controle_de_ofs.models.Employee;
import com.stefanini.controle_de_ofs.repository.RepositoryEmployee;
import com.stefanini.controle_de_ofs.services.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private RepositoryEmployee action;

    @Autowired
    private ServiceEmployee serviceEmployee;

    @GetMapping("/listaColaboradores")
    public ResponseEntity<?> findAllEmployees(){
        return action.findAllEmployees();
    }

    @PostMapping("/cadastroEmployee")
    public ResponseEntity<?> newEmployee(@RequestBody Employee obj){
        return serviceEmployee.newEmployee(obj);
    }


}
