package dxc.assessment.app.model;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;


@Entity
@Inheritance
@DiscriminatorColumn(name = "User_Type")
@Data
public abstract class AccountHolder extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @NotBlank(message = "First Name is required")
    protected String firstName;

    @NotBlank(message = "Last Name is required")
    protected String lastName;

    @Email(message = "Invalid email format")
    protected String email;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    protected String password;

    @Pattern(regexp = "\\d{8}", message = "Phone number must be 8 digits")
    protected String phone;

    public AccountHolder() {
    }

    public AccountHolder(
            boolean isDeleted,
            String createdBy,
            LocalDateTime createdTime,
            String lastUpdatedBy,
            LocalDateTime lastUpdatedTime,
            String firstName,
            String lastName,
            String email,
            String password,
            String phone) {
        super(isDeleted, createdBy, createdTime, lastUpdatedBy, lastUpdatedTime);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Account Holder Attributes{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}' +
                "\n\t" +
                super.toString();
    }
}
