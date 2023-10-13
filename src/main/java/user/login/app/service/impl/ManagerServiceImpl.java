package user.login.app.service.impl;

import user.login.app.model.Manager;
import user.login.app.repository.ManagerRepository;
import user.login.app.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;
    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> findAllManagers() {
        return managerRepository.findAll();
    }
    public List<Manager> findAllValidManagers() {
        return managerRepository.findByDeleted(false);
    }
}
