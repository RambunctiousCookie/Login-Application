package dxc.assessment.app.service;

import dxc.assessment.app.model.Department;
import dxc.assessment.app.model.Employee;

import java.util.List;

public interface DepartmentService {
    List<Department> findAllDepartments();
    List<Department> findAllValidDepartments();
}
