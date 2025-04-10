package com.stefanini.controle_de_ofs.controllers;

import com.jayway.jsonpath.internal.path.ArraySliceOperation;
import com.stefanini.controle_de_ofs.models.User;
import com.stefanini.controle_de_ofs.repository.RepositoryUser;
import com.stefanini.controle_de_ofs.services.ServiceUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name = "Usuários")
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")

public class UserController {
    private RepositoryUser action;

    @Autowired
    private ServiceUser serviceUser;

    @Operation(summary = "Rota para listar todos os usuários")
    @GetMapping("/findAll")
    public ResponseEntity<?> select(){
        return serviceUser.findAll();
    }

    @Operation(summary = "Rota para listar todos os usuários pelo ID")
    @GetMapping("/findByID/{id}")
    public ResponseEntity<?> selectID(@PathVariable int id) {
        return serviceUser.findById(id);
    }

    @Operation(summary = "Rota para adicionar usuários")
    @PostMapping("/new")
    public ResponseEntity<?> cadastrar(@RequestBody User obj){
        return serviceUser.cadastrar(obj);
    }

    @Operation(summary = "Rota para editar usuários")
    @PutMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody User obj){
        return serviceUser.edit(obj);
    }

    @Operation(summary = "Rota para deletar usuários")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteByID(@PathVariable int id){
        return serviceUser.deleteById(id);
  }

    @Operation(summary = "Rota para encontrar todos os gerentes")
    @GetMapping("/Managers")
    public ResponseEntity<?> findManager(String role){
        return serviceUser.findByRole("manager");
    }

    @Operation(summary = "Rota para encontrar todos os rts")
    @GetMapping("/RTs")
    public ResponseEntity<?> findRts(String role){
        return serviceUser.findByRole("rt");
    }
}
