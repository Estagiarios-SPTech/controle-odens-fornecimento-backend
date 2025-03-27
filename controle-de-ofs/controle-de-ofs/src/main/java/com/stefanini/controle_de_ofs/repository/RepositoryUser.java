package  com.stefanini.controle_de_ofs.repository;


import com.stefanini.controle_de_ofs.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryUser extends CrudRepository<User, Integer> {

    List<User> findAll(Integer id);

    @Query(value = "SELECT id, nome FROM user WHERE id = :id")
    Integer findById();


}

