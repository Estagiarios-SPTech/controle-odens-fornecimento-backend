package com.stefanini.controle_de_ofs.repository;

import com.stefanini.controle_de_ofs.models.OrdemFornecimento;
import com.stefanini.controle_de_ofs.projection.OrdemFornecimentoProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositoryOrdemFornecimento extends CrudRepository<OrdemFornecimento, Integer>{
    @Query(value = "select codigo, description, ordem_fornecimento.status, created_at, updated_at, name as collaborator from ordem_fornecimento join employees  on employees.id = collaborator_id join users on users.id = user_role_employee", nativeQuery = true)
    List<OrdemFornecimentoProjection> acharTudoSemMandarObjetoChaveEstrangeira();
    OrdemFornecimento findByCodigo(Integer codigo);
    Integer countByCodigo(Integer codigo);


}
