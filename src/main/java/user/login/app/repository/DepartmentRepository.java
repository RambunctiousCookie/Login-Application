package user.login.app.repository;
import user.login.app.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    public List<Department> findByDeleted(boolean deleted);
}