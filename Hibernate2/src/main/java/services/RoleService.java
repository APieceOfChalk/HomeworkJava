package services;

import dao.RoleDao;
import models.Role;

public class RoleService {
    private RoleDao roleDao = new RoleDao();

    public RoleService(){}

    public void saveRole(Role Role){
        roleDao.save(Role);
    }

    public Role findRole(int id){
        return roleDao.findById(id);
    }
}
