package dxc.assessment.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Department extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Department name is required")
    private String name;

    @NotBlank(message = "Department description is required")
    private String description;

    @OneToOne(mappedBy = "department")
    private Manager manager;

    @OneToMany(targetEntity = Employee.class, mappedBy = "department", fetch = FetchType.EAGER)
    private List<Employee> employees;

    public Department(
            String createdBy,
            LocalDateTime createdTime,
            String lastUpdatedBy,
            LocalDateTime lastUpdatedTime,
            String name,
            String description,
            Manager manager) {
        super(false, createdBy, createdTime, lastUpdatedBy, lastUpdatedTime);
        this.name = name;
        this.description = description;
        this.manager = manager;
        this.employees = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", manager=" + manager.getUserId() +
                ", employees=" + employees.stream().map(Employee::getUserId) +
                '}';
    }
}
