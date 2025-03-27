package com.stefanini.controle_de_ofs.controllers;

import com.stefanini.controle_de_ofs.models.User;
import com.stefanini.controle_de_ofs.repository.RepositoryUser;
import com.stefanini.controle_de_ofs.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private RepositoryUser action;

    @Autowired
    private ServiceUser serviceUser;

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody User obj){
        return serviceUser.cadastrar(obj);
    }
}
