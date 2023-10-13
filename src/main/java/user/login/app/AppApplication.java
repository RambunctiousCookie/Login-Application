package user.login.app;

import user.login.app.DTO.BaseModelDTO;
import user.login.app.model.Employee;
import user.login.app.model.Department;
import user.login.app.model.Manager;
import user.login.app.repository.DepartmentRepository;
import user.login.app.repository.EmployeeRepository;
import user.login.app.repository.ManagerRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}


	@Bean
	CommandLineRunner initData(
			ManagerRepository managerRepository,
			EmployeeRepository employeeRepository,
			DepartmentRepository departmentRepository) {
		return (args) -> {
			LocalDateTime now = LocalDateTime.now();
			String adminId = "admin_one";
			BaseModelDTO baseModelDTO = new BaseModelDTO(false, adminId, now, adminId, now);

			Department department = departmentRepository.saveAndFlush(new Department(baseModelDTO, "Success Department", "Engineering the future of society."));

			String salt = BCrypt.gensalt();
			Manager manager = managerRepository.saveAndFlush(new Manager(baseModelDTO, "Mark", "Oleg",
					"manager_one", BCrypt.hashpw("Sparkling_Ocean_456", salt), salt, "97224466", department));

			salt = BCrypt.gensalt();
			Employee employeeOne = employeeRepository.saveAndFlush(new Employee(baseModelDTO, "Emma", "Okas","employee_one", BCrypt.hashpw("Radiant_Tiger_789", salt), salt, "98876543", department));

			salt = BCrypt.gensalt();
			Employee employeeTwo = employeeRepository.saveAndFlush(new Employee(baseModelDTO, "Eugene", "Trellis","employee_two", BCrypt.hashpw("Mystic_Dragon_357", salt), salt, "98011234", department));
		};
	}
}
