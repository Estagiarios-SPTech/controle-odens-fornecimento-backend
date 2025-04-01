package com.stefanini.controle_de_ofs.repository;

import com.stefanini.controle_de_ofs.models.OrdemFornecimento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Repositorio extends CrudRepository<OrdemFornecimento, Integer>{
    List<OrdemFornecimento> findAll();
    OrdemFornecimento findByCodigo(Integer codigo);
    Integer countByCodigo(Integer codigo);
}
