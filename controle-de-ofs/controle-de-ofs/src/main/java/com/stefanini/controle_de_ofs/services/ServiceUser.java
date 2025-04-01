package com.stefanini.controle_de_ofs.services;

import com.stefanini.controle_de_ofs.models.User;
import com.stefanini.controle_de_ofs.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUser {
    private String message;

    @Autowired
    private RepositoryUser action;

    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> cadastrar(User obj){
        if(obj.getName().isEmpty()){
            message = "O nome precisa ser preenchido";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (obj.getEmail().isEmpty()) {
            message = "Informe um endereço de e-mail válido";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (obj.getRole().isEmpty()) {
            message = "Informe um cargo válido";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.save(obj), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> findById(int  id){
        if (action.countById(id) == 0){
            message = "Usuário não encontrado";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(action.findById(id), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> edit(User obj){
        if (action.countById(obj.getId()) == 0){
            message = "ID do Usuário não encontrado";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else if(obj.getName().isEmpty()){
            message = "O nome precisa ser preenchido";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (obj.getEmail().isEmpty()) {
            message = "Informe um endereço de e-mail válido";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (obj.getRole().isEmpty()) {
            message = "Informe um cargo válido";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.save(obj), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> deleteById(int id) {
        if (action.countById(id) == 0) {
            message = "Usuário não encontrado";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            List<User> obj = action.findById(id);
            if (!obj.isEmpty()) {
                User user = obj.get(0);;
                action.delete(user);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }


}
