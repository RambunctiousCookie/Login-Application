package dxc.assessment.app.repository;
import dxc.assessment.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findByDeleted(boolean deleted);
    public List<Employee> findAll();
}