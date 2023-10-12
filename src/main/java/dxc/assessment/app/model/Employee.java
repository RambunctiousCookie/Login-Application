package dxc.assessment.app.model;
import dxc.assessment.app.DTO.BaseModelDTO;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@DiscriminatorColumn(name = "User_Type")
@DiscriminatorValue("Employee")
@Data
public class Employee extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @NotBlank(message = "First Name is required")
    protected String firstName;

    @NotBlank(message = "Last Name is required")
    protected String lastName;

    @NotBlank(message = "User ID is required")
    @Column(unique = true)
    protected String userId;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    protected String password;

    @NotBlank(message = "Salt is required")
    protected String salt;

    @Pattern(regexp = "\\d{8}", message = "Phone number must be 8 digits")
    protected String phone;

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
            String phone,
            Department department) {
        super(false, createdBy, createdTime, lastUpdatedBy, lastUpdatedTime);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.password = password;
        this.salt = salt;
        this.phone = phone;
        this.department =  department;
    }

    public Employee(
            BaseModelDTO baseModelDTO,
            String firstName,
            String lastName,
            String userId,
            String password,
            String salt,
            String phone,
            Department department) {
        super(baseModelDTO);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.password = password;
        this.salt = salt;
        this.phone = phone;
        this.department = department;
    }

    @Override
    public String toString() {
        //do not display salt, pw
        return "Employee {" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + userId + '\'' +
                ", phone='" + phone + '\'' +
                "} " +
                super.toString()+"\n";
    }
}
