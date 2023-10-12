package dxc.assessment.app;

import dxc.assessment.app.configuration.SecurityConfig;
import dxc.assessment.app.model.AccountHolder;
import dxc.assessment.app.model.Department;
import dxc.assessment.app.model.Employee;
import dxc.assessment.app.model.Manager;
import dxc.assessment.app.repository.DepartmentRepository;
import dxc.assessment.app.repository.EmployeeRepository;
import dxc.assessment.app.repository.ManagerRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

			String salt = BCrypt.gensalt();
			Manager manager = managerRepository.saveAndFlush(new Manager(adminId, now, adminId, now, "Manager", "One",
					"manager_one", BCrypt.hashpw("Sparkling_Ocean_456", salt), salt, "97224466"));

			salt = BCrypt.gensalt();
			Employee employeeOne = employeeRepository.saveAndFlush(new Employee(adminId, now, adminId, now, "Employee", "One","employee_one", BCrypt.hashpw("Radiant_Tiger_789", salt), salt, "98876543"));

			salt = BCrypt.gensalt();
			Employee employeeTwo = employeeRepository.saveAndFlush(new Employee(adminId, now, adminId, now, "Employee", "Two","employee_two", BCrypt.hashpw("Mystic_Dragon_357", salt), salt, "98011234"));


			Department department = departmentRepository.saveAndFlush(new Department(adminId, now, adminId, now, "Department One", "The first department", manager));

			AccountHolder[] accountHolders = {
					manager,
					employeeOne,
					employeeTwo
			};

			//Arrays.stream(accountHolders).forEach(x->x.set);


//			String basepw = BCrypt.hashpw("Radiant_Tiger_789", salt);
//			String inputpw = BCrypt.hashpw("Radiant_Tiger_789", salt);
//			System.out.println("\n\t"+basepw.equals(inputpw));

		};
	}
}
