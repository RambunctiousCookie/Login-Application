package dxc.assessment.app;

import com.fasterxml.jackson.databind.ser.Serializers;
import dxc.assessment.app.DTO.BaseModelDTO;
import dxc.assessment.app.model.BaseModel;
import dxc.assessment.app.model.Employee;
import dxc.assessment.app.model.Department;
import dxc.assessment.app.model.Manager;
import dxc.assessment.app.repository.DepartmentRepository;
import dxc.assessment.app.repository.EmployeeRepository;
import dxc.assessment.app.repository.ManagerRepository;
import org.hibernate.ObjectNotFoundException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;
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
			BaseModelDTO baseModelDTO = new BaseModelDTO(false, adminId, now, adminId, now);

			Department department = departmentRepository.saveAndFlush(new Department(baseModelDTO, "Success Department", "Engineering the future of society."));

			String salt = BCrypt.gensalt();
			Manager manager = managerRepository.saveAndFlush(new Manager(baseModelDTO, "Manager", "One",
					"manager_one", BCrypt.hashpw("Sparkling_Ocean_456", salt), salt, "97224466", department));

			salt = BCrypt.gensalt();
			Employee employeeOne = employeeRepository.saveAndFlush(new Employee(baseModelDTO, "Employee", "One","employee_one", BCrypt.hashpw("Radiant_Tiger_789", salt), salt, "98876543", department));

			salt = BCrypt.gensalt();
			Employee employeeTwo = employeeRepository.saveAndFlush(new Employee(baseModelDTO, "Employee", "Two","employee_two", BCrypt.hashpw("Mystic_Dragon_357", salt), salt, "98011234", department));

//			Employee[] employees = {
//					manager,
//					employeeOne,
//					employeeTwo
//			};

			int entityId = 1;
			if (departmentRepository.findById(entityId).isPresent()) {
				Department foundDepartment = departmentRepository.findById(entityId).get();
				System.out.println(foundDepartment);
				foundDepartment.getEmployees().stream().forEach(System.out::println);
			} else {
				throw new ObjectNotFoundException(departmentRepository.findById(entityId),"Entity with ID " + entityId + " not found");
			}

			Employee foundEmployee = employeeRepository.findByUsernameAndDeleted(manager.getUsername(),false);	//query is derived; expected behavior
//			Employee foundEmployee = employeeRepository.findByUsername("foo");

			if (foundEmployee == null)
				System.out.println("Employee does not exist!");
			else if (foundEmployee instanceof Manager)
				System.out.println(foundEmployee.getUsername()+ " is a manager.");
				//is a manager
			else
				System.out.println(foundEmployee.getUsername()+ " is an employee.");

			List<Employee> employeesByDept = employeeRepository.findAllByDepartment(department);


//			employeeTwo.setDeleted(true);
//			employeeRepository.saveAndFlush(employeeTwo);
//
//			//List<Employee> employeeListTeamOne = employeeRepository.findEmployeesByDepartmentId(department.getId());
//			List<Employee> employeeListTeamOne = employeeRepository.findEmployeesByDepartmentIdAndDeleted(department.getId(),false);
//
//			employeeListTeamOne.forEach(System.out::println);


			System.out.println();

			//Arrays.stream(employees).forEach(System.out::println);

//			String basepw = BCrypt.hashpw("Radiant_Tiger_789", salt);
//			String inputpw = BCrypt.hashpw("Radiant_Tiger_789", salt);
//			System.out.println("\n\t"+basepw.equals(inputpw));

		};
	}
}
