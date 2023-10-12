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

    @NotBlank(message = "User ID is required")
    @Column(unique = true)
    protected String userId;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    protected String password;

    @NotBlank(message = "Salt is required")
    protected String salt;

    @Pattern(regexp = "\\d{8}", message = "Phone number must be 8 digits")
    protected String phone;

    public AccountHolder() {
    }

    public AccountHolder(
            boolean deleted,
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
        super(deleted, createdBy, createdTime, lastUpdatedBy, lastUpdatedTime);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.password = password;
        this.salt = salt;
        this.phone = phone;
    }

    @Override
    public String toString() {
        //do not display salt
        return "Account Holder Attributes{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}' +
                "\n\t" +
                super.toString();
    }
}
