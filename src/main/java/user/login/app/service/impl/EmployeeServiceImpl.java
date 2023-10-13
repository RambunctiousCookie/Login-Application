package user.login.app.service.impl;

import user.login.app.model.Employee;
import user.login.app.repository.EmployeeRepository;
import user.login.app.service.EmployeeService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
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
        return employeeRepository.findByUsernameAndDeleted(username, false);
    }

    public List<Employee> findValidEmployeesByDeptId(Long departmentId){
        return employeeRepository.findEmployeesByDepartmentIdAndDeleted(departmentId, false);
    }

    @Transactional
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
