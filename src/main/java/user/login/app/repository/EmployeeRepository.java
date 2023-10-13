package user.login.app.repository;
import user.login.app.model.Department;
import user.login.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findByDeleted(boolean deleted);
    public List<Employee> findAllByDepartment(Department department);   //derived query
    public Employee findByUsername(String username);
    public Employee findByUsernameAndDeleted(String username, boolean deleted);
    @Query("SELECT e " +
            "FROM Employee e " +
            "WHERE e.department.id = :departmentId AND e.deleted = :deleted")
    public List<Employee> findEmployeesByDepartmentIdAndDeleted(
            @Param("departmentId") Long departmentId,
            @Param("deleted") boolean deleted);
    @Query("SELECT e " +
            "FROM Employee e " +
            "WHERE e.department.id = :departmentId")
    public List<Employee> findEmployeesByDepartmentId(@Param("departmentId") Long departmentId);
}