package com.stefanini.controle_de_ofs.controllers;

import com.stefanini.controle_de_ofs.models.OrdemFornecimento;
import com.stefanini.controle_de_ofs.services.OrdemFornecimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Ordem de Fornecimento")
@RestController
@RequestMapping("/ordemFornecimento")
public class OrdemFornecimentoController {
    @Autowired
    private OrdemFornecimentoService ordemFornecimentoService;

    @Operation(summary = "Cadastro")
    @PostMapping("/criar")
    public ResponseEntity<?> criarOrdemFornecimento(@RequestBody OrdemFornecimento obj){
        return ordemFornecimentoService.cadastrar(obj);
    }

    @Operation(summary = "Listagem")
    @GetMapping("/listar")
    public ResponseEntity<?> listarTudo(){
        return ordemFornecimentoService.listarTudo();
    }

    @Operation(summary = "Listagem por código")
    @GetMapping("/listar/{codigo}")
    public ResponseEntity<?> listarPorId(@PathVariable Integer codigo){
        return ordemFornecimentoService.listarPorCodigo(codigo);
    }

    @Operation(summary = "Alteração")
    @PutMapping("/alterar")
    public ResponseEntity<?> alterarOrdemFornecimento(@RequestBody OrdemFornecimento obj){
        return ordemFornecimentoService.alterar(obj);
    }

    @Operation(summary = "Exclusão por código")
    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<?> deletarOrdemFornecimento(@PathVariable Integer codigo){
        return ordemFornecimentoService.excluir(codigo);
    }
}
