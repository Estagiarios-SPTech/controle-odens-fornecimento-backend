package com.stefanini.controle_de_ofs.controllers;

import com.stefanini.controle_de_ofs.models.User;
import com.stefanini.controle_de_ofs.repository.RepositoryUser;
import com.stefanini.controle_de_ofs.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private RepositoryUser action;

    @Autowired
    private ServiceUser serviceUser;

    @GetMapping("/allUsers")
    public ResponseEntity<?> select(){
        return serviceUser.findAll();
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody User obj){
        return serviceUser.cadastrar(obj);
    }
}
