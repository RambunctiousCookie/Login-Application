package dxc.assessment.app.repository;
import dxc.assessment.app.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    //TODO: Manager is basically an employee- use polymorphism?
    public List<Manager> findByDeleted(boolean deleted);
}