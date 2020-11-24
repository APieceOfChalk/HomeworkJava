package services;

import dao.GroupDao;
import models.Group;

public class GroupService {
    private GroupDao groupDao = new GroupDao();

    public GroupService(){}

    public void saveGroup(Group group){
        groupDao.save(group);
    }

    public Group findGroup(int id){
        return groupDao.findById(id);
    }
}
