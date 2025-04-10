package  com.stefanini.controle_de_ofs.repository;


import com.stefanini.controle_de_ofs.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryUser extends CrudRepository<User, Integer> {

    List<User> findAll();

//    @Query(value = "SELECT id, nome FROM users WHERE id = :id", nativeQuery = true)
    List <User> findById(int id);

    int countById(int codigo);

    List <User> findByRole(String role);

    @Query(value = "SELECT id, name, email, role FROM users WHERE role = 'manager'", nativeQuery = true)
    List <User> findManagers();

    @Query(value = "SELECT id, name, email, role FROM users WHERE role = 'manager' AND name = :name", nativeQuery = true)
    User findSpecificManager(String name);

    @Query(value = "SELECT id, name, email, role FROM users WHERE role = 'RT' AND name = :name", nativeQuery = true)
    User findSpecificRT(String name);
}

