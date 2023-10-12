package dxc.assessment.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@DiscriminatorValue("Employee")
@Data
public class Employee extends AccountHolder {
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {
    }

    public Employee(
            String createdBy,
            LocalDateTime createdTime,
            String lastUpdatedBy,
            LocalDateTime lastUpdatedTime,
            String firstName,
            String lastName,
            String userId,
            String password,
            String salt,
            String phone) {
        super(false, createdBy, createdTime, lastUpdatedBy, lastUpdatedTime, firstName, lastName, userId, password, salt,
                phone);
    }

    @Override
    public String toString() {
        return "Student" +
                "\n\t" +
                super.toString();
    }
}