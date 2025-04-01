package com.stefanini.controle_de_ofs.services;

import com.stefanini.controle_de_ofs.models.Employee;
import com.stefanini.controle_de_ofs.repository.RepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceEmployee {

    @Autowired
    private RepositoryEmployee action;

    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }


    public ResponseEntity<?> cadastrar(Employee obj) {
        if (obj.getEmployee() == null) {
            System.out.println("O colaborador precisa ser informado");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (obj.getStatus() == null || obj.getStatus().isEmpty()) {
            System.out.println("O status precisa ser preenchido");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.save(obj), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> findById(int id) {
        if (!action.existsById(id)) {
            System.out.println("Colaborador não encontrado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(action.findById(id).get(), HttpStatus.OK);
        }
    }


    public ResponseEntity<?> findByStatus(String status) {
        List<Employee> employees = action.findByStatus(status);
        if (employees.isEmpty()) {
            System.out.println("Nenhum colaborador encontrado com o status fornecido");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> edit(Employee obj) {
        if (action.findById(obj.getId()).isEmpty()) {
            System.out.println("ID do colaborador não encontrado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (obj.getEmployee() == null) {
            System.out.println("O colaborador precisa ser informado");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (obj.getStatus() == null || obj.getStatus().isEmpty()) {
            System.out.println("O status precisa ser preenchido");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(action.save(obj), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> deleteById(int id) {
        if (!action.existsById(id)) {
            System.out.println("Colaborador não encontrado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            action.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
