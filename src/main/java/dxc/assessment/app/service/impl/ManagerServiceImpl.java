package dxc.assessment.app.service.impl;

import dxc.assessment.app.model.Employee;
import dxc.assessment.app.model.Manager;
import dxc.assessment.app.repository.EmployeeRepository;
import dxc.assessment.app.repository.ManagerRepository;
import dxc.assessment.app.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private ManagerRepository managerRepository;

    //constructor injection for DI/testing
    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> findAllManagers() {
        return managerRepository.findAll();
    }
    public List<Manager> findAllValidEmployees() {
        return managerRepository.findByIsDeleted(false);
    }
}
