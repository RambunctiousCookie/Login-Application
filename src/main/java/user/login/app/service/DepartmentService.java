package user.login.app.service;

import user.login.app.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAllDepartments();
    List<Department> findAllValidDepartments();
}
