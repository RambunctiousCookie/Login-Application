package user.login.app.repository;
import user.login.app.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    //TODO: Manager is basically an employee- can use polymorphism for future builds
    public List<Manager> findByDeleted(boolean deleted);
}