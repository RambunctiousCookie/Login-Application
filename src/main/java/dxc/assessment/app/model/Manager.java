package dxc.assessment.app.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@DiscriminatorValue("Manager")
@Data
public class Manager extends AccountHolder {
    public Manager() {
    }

    public Manager(
            String createdBy,
            LocalDateTime createdTime,
            String lastUpdatedBy,
            LocalDateTime lastUpdatedTime,
            String firstName,
            String lastName,
            String email,
            String password,
            String phone) {
        super(false, createdBy, createdTime, lastUpdatedBy, lastUpdatedTime, firstName, lastName, email,
                password, phone);

    }

    @Override
    public String toString() {

        return "Lecturer" +
                "\n\t" +
                super.toString();
    }
}