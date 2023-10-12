package dxc.assessment.app;

import dxc.assessment.app.configuration.SecurityConfig;
import dxc.assessment.app.model.Employee;
import dxc.assessment.app.model.Manager;
import dxc.assessment.app.repository.EmployeeRepository;
import dxc.assessment.app.repository.ManagerRepository;
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
			EmployeeRepository employeeRepository) {
		return (args) -> {
			LocalDateTime now = LocalDateTime.now();
			String sampleEmail = "admin@success.com";

			String salt = BCrypt.gensalt();
			Manager manager = managerRepository.saveAndFlush(new Manager(sampleEmail, now, sampleEmail, now, "Manager", "One",
					"manager@success.com", BCrypt.hashpw("Sparkling_Ocean_456", salt), salt, "97224466"));

			salt = BCrypt.gensalt();
			Employee employeeOne = employeeRepository.saveAndFlush(new Employee(sampleEmail, now, sampleEmail, now, "Employee", "One","employee.one@success.com", BCrypt.hashpw("Radiant_Tiger_789", salt), salt, "98876543"));

			salt = BCrypt.gensalt();
			Employee employeeTwo = employeeRepository.saveAndFlush(new Employee(sampleEmail, now, sampleEmail, now, "Employee", "Two","employee.two@success.com", BCrypt.hashpw("Mystic_Dragon_357", salt), salt, "98011234"));

//			String basepw = BCrypt.hashpw("Radiant_Tiger_789", salt);
//			String inputpw = BCrypt.hashpw("Radiant_Tiger_789", salt);
//			System.out.println("\n\t"+basepw.equals(inputpw));

		};
	}
}
