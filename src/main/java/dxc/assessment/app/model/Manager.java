package dxc.assessment.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@DiscriminatorValue("Manager")
@Data
public class Manager extends AccountHolder {
    @OneToOne
    private Department department;

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
            String phone) {
        super(false, createdBy, createdTime, lastUpdatedBy, lastUpdatedTime, firstName, lastName, userId,
                password, salt, phone);

    }

    @Override
    public String toString() {

        return "Lecturer" +
                "\n\t" +
                super.toString();
    }
}