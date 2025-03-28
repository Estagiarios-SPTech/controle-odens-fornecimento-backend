package com.stefanini.controle_de_ofs.services;

import com.stefanini.controle_de_ofs.repository.RepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ServiceEmployee {
    @Autowired
    private RepositoryEmployee action;


    public ResponseEntity<?> findAllEmployees() {
        return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }


}
