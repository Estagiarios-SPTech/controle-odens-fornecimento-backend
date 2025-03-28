package  com.stefanini.controle_de_ofs.repository;

import com.stefanini.controle_de_ofs.models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryEmployee extends CrudRepository<Employee, Integer> {

    List<Employee> findAll(Integer id);

//    @Query(value = "SELECT e.id, e.name, e.nome  FROM Employees WHERE  ", nativeQuery = true)
//    Long findEmployeeByRT();

}