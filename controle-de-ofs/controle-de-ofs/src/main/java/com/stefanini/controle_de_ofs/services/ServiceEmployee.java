package com.stefanini.controle_de_ofs.services;

import com.stefanini.controle_de_ofs.models.Employee;
import com.stefanini.controle_de_ofs.repository.RepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceEmployee {

    @Autowired
    private RepositoryEmployee action;


    public ResponseEntity<?> findAllEmployees() {
        return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> newEmployee(Employee obj){
        if (obj.getEmployee() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if(obj.getRt() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (obj.getManager() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.save(obj), HttpStatus.CREATED);
        }

    }

}
