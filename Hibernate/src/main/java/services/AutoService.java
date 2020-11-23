package services;

import dao.AutoDao;
import models.Auto;
import models.User;

import java.util.List;

public class AutoService {
    private AutoDao autoDao = new AutoDao();

    public AutoService() {}

    public Auto findAuto(int id){
        return autoDao.findById(id);
    }

    public void saveAuto(Auto auto){
        autoDao.save(auto);
    }

    public void updateAuto(Auto auto){
        autoDao.update(auto);
    }

    public void deleteAuto(Auto auto){
        autoDao.delete(auto);
    }

    public User findUserByAutoId(int auto_id) {
        return autoDao.findUserByAutoId(auto_id);
    }

    public List<Auto> findAllAutos(){
        return autoDao.findAll();
    }
}
