package dxc.assessment.app;

import dxc.assessment.app.configuration.SecurityConfig;
import dxc.assessment.app.model.Employee;
import dxc.assessment.app.model.Manager;
import dxc.assessment.app.repository.EmployeeRepository;
import dxc.assessment.app.repository.ManagerRepository;
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
			String sampleEmail = "jason.tay.nw@gmail.com";

			Manager manager = managerRepository.saveAndFlush(new Manager(sampleEmail, now, sampleEmail, now, "Manager", "One",
					"manager@success.com", SecurityConfig.passwordEncoder().encode("Sparkling_Ocean_456"), "97224466"));

			Employee employeeOne = employeeRepository.saveAndFlush(new Employee(sampleEmail, now, sampleEmail, now, "Employee", "One","employee.one@success.com", SecurityConfig.passwordEncoder().encode("Radiant_Tiger_789"), "98876543"));
			Employee employeeTwo = employeeRepository.saveAndFlush(new Employee(sampleEmail, now, sampleEmail, now, "Employee", "Two","employee.two@success.com", SecurityConfig.passwordEncoder().encode("Mystic_Dragon_357"), "98011234"));
		};
	}
}
