package  com.stefanini.controle_de_ofs.repository;

import com.stefanini.controle_de_ofs.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEmployee extends CrudRepository<Employee, Integer> {

}