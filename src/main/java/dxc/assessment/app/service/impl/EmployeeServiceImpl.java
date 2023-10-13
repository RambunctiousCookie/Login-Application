package dxc.assessment.app.service.impl;

import dxc.assessment.app.model.Employee;
import dxc.assessment.app.repository.EmployeeRepository;
import dxc.assessment.app.service.EmployeeService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
    public List<Employee> findAllValidEmployees() {
        return employeeRepository.findByDeleted(false);
    }

    public Employee findValidEmployeeByUsername(String username){
        //TODO: throw/propagate error to thymeleaf and handle it with user message
        return employeeRepository.findByUsernameAndDeleted(username, false);
    }

    public List<Employee> findValidEmployeesByDeptId(Long departmentId){
        return employeeRepository.findEmployeesByDepartmentIdAndDeleted(departmentId, false);
    }

    public boolean authenticateLogin(String username, String password){
        boolean loginSuccess = false;
        Employee currentEmployee = findValidEmployeeByUsername(username);

        if (currentEmployee != null) {
            String hashedInputPassword = BCrypt.hashpw(password, currentEmployee.getSalt());
            if(hashedInputPassword.equals(currentEmployee.getPassword()))
                loginSuccess = true;
        }
        return loginSuccess;
    }

}
