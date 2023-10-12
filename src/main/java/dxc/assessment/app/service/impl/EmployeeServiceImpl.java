package dxc.assessment.app.service.impl;

import dxc.assessment.app.model.Employee;
import dxc.assessment.app.repository.EmployeeRepository;
import dxc.assessment.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    //constructor injection for DI/testing
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
    public List<Employee> findAllValidEmployees() {
        return employeeRepository.findByIsDeleted(false);
    }

}
