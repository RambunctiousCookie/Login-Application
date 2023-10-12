package dxc.assessment.app.service.impl;
import dxc.assessment.app.model.Department;
import dxc.assessment.app.model.Employee;
import dxc.assessment.app.repository.DepartmentRepository;
import dxc.assessment.app.repository.EmployeeRepository;
import dxc.assessment.app.service.DepartmentService;
import dxc.assessment.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

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
