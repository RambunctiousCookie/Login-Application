package dxc.assessment.app.service;

import dxc.assessment.app.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();
    List<Employee> findAllValidEmployees();
}
