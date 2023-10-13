package user.login.app.model;
import user.login.app.DTO.BaseModelDTO;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Entity
@DiscriminatorValue("Manager")
@Data
public class Manager extends Employee {
    //Future manager-related fields
    public Manager() {
    }

    public Manager(
            String createdBy,
            LocalDateTime createdTime,
            String lastUpdatedBy,
            LocalDateTime lastUpdatedTime,
            String firstName,
            String lastName,
            String userId,
            String password,
            String salt,
            String phone,
            Department department) {
        super(createdBy, createdTime, lastUpdatedBy, lastUpdatedTime, firstName, lastName, userId,
                password, salt, phone, department);
    }

    public Manager(
            BaseModelDTO baseModelDTO,
            String firstName,
            String lastName,
            String userId,
            String password,
            String salt,
            String phone,
            Department department) {
        super(baseModelDTO, firstName, lastName, userId, password, salt, phone, department);
    }

    @Override
    public String toString() {
        //return super.toString().replace("Employee {","Manager {");
        return "Manager" + super.toString().substring(8);
    }
}

