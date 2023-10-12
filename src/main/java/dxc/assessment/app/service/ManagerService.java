package dxc.assessment.app.service;

import dxc.assessment.app.model.Manager;

import java.util.List;

public interface  ManagerService {

    List<Manager> findAllManagers();
    List<Manager> findAllValidEmployees();
}
