package dxc.assessment.app.model;

import dxc.assessment.app.DTO.BaseModelDTO;
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

    @OneToMany(targetEntity = Employee.class, mappedBy = "department", fetch = FetchType.EAGER)
    private List<Employee> employees;

    public Department(){
    }

    public Department(
            String createdBy,
            LocalDateTime createdTime,
            String lastUpdatedBy,
            LocalDateTime lastUpdatedTime,
            String name,
            String description) {
        super(false, createdBy, createdTime, lastUpdatedBy, lastUpdatedTime);
        this.name = name;
        this.description = description;
        this.employees = new ArrayList<>();
    }

    public Department(BaseModelDTO baseModelDTO, String name, String description) {
        super(baseModelDTO);
        this.name = name;
        this.description = description;
        this.employees = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Department {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
//                ", manager=" + manager.getUserId() +
                ", employees=" + employees +
                '}';
    }
}
