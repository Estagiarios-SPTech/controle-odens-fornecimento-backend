package com.stefanini.controle_de_ofs.services;

import com.stefanini.controle_de_ofs.models.OrdemFornecimento;
import com.stefanini.controle_de_ofs.repository.RepositoryOrdemFornecimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrdemFornecimentoService {
    private String message;

    @Autowired
    private RepositoryOrdemFornecimento acao;

    public ResponseEntity<?> cadastrar(OrdemFornecimento obj){
        if(obj.getDescription() == "" ||
            obj.getStatus() == ""){
            message = "Nenhum campo pode estar vazio";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        else{
            obj.setCreated_at(LocalDate.now());
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> listarTudo(){
        return new ResponseEntity<>(acao.acharTudoSemMandarObjetoChaveEstrangeira(), HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorCodigo(Integer codigo){
        if(acao.countByCodigo(codigo) == 0){
            message = "Código não encontrado";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(acao.findByCodigo(codigo), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> alterar(OrdemFornecimento obj){
        if(acao.countByCodigo(obj.getCodigo()) == 0){
            message = "Código não encontrado";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        else if(obj.getDescription() == "" ||
                obj.getStatus() == ""){
            message = "Nenhum campo pode estar vazio";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        else{
            OrdemFornecimento objEncontrado = acao.findByCodigo(obj.getCodigo());
            obj.setCreated_at(objEncontrado.getCreated_at());
            obj.setUpdated_at(LocalDate.now());
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> excluir(Integer codigo){
        if(acao.countByCodigo(codigo) == 0){
            message = "Código não encontrado";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        else{
            OrdemFornecimento objEncontrado = acao.findByCodigo(codigo);
            acao.delete(objEncontrado);

            message = "Exclusão realizada com sucesso";
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }
}
