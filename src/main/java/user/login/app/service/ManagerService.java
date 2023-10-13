package user.login.app.service;

import user.login.app.model.Manager;

import java.util.List;

public interface  ManagerService {

    List<Manager> findAllManagers();
    List<Manager> findAllValidManagers();
}
