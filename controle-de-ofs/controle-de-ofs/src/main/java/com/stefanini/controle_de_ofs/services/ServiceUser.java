package com.stefanini.controle_de_ofs.services;

import com.stefanini.controle_de_ofs.models.User;
import com.stefanini.controle_de_ofs.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser {

    @Autowired
    private RepositoryUser action;

    public ResponseEntity<?> findUsers(){
        return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> cadastrar(User obj){
        if(obj.getName().isEmpty()){
            System.out.println("O nome precisa ser preenchido");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (obj.getEmail().isEmpty()) {
            System.out.println("Informe um endereço de e-mail válido");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (obj.getRole().isEmpty()) {
            System.out.println("Informe um cargo válido");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.save(obj), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> findUserById(User obj, Integer id){
        if (obj.getId().describeConstable().isEmpty()){
            System.out.println("Usuário não encontrado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {                                        // ?????????
            return new ResponseEntity<>(action.findById(id));
        }
    }
}
