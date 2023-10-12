package dxc.assessment.app.repository;
import dxc.assessment.app.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    public List<Manager> findByIsDeleted(boolean isDeleted);
    public List<Manager> findAll();

}