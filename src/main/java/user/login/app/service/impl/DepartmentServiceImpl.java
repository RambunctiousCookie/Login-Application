package user.login.app.service.impl;
import user.login.app.model.Department;
import user.login.app.repository.DepartmentRepository;
import user.login.app.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    //constructor injection for DI/testing
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }
    public List<Department> findAllValidDepartments() {
        return departmentRepository.findByDeleted(false);
    }

}
