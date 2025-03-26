package com.stefanini.controle_de_ofs.controllers;

import com.stefanini.controle_de_ofs.models.OrdemFornecimento;
import com.stefanini.controle_de_ofs.services.OrdemFornecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ordemFornecimento")
public class OrdemFornecimentoController {
    @Autowired
    private OrdemFornecimentoService ordemFornecimentoService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarOrdemFornecimento(@RequestBody OrdemFornecimento obj){
        return ordemFornecimentoService.cadastrar(obj);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarTudo(){
        return ordemFornecimentoService.listarTudo();
    }

    @GetMapping("/listar/{codigo}")
    public ResponseEntity<?> listarPorId(@PathVariable Integer codigo){
        return ordemFornecimentoService.listarPorCodigo(codigo);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterarOrdemFornecimento(@RequestBody OrdemFornecimento obj){
        return ordemFornecimentoService.alterar(obj);
    }

    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<?> deletarOrdemFornecimento(@PathVariable Integer codigo){
        return ordemFornecimentoService.excluir(codigo);
    }
}
