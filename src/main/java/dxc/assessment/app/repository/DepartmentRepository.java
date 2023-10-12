package dxc.assessment.app.repository;
import dxc.assessment.app.model.Department;
import dxc.assessment.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    public List<Department> findByDeleted(boolean deleted);
}