package dao;

import models.Role;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class RoleDao extends Dao<Role> {
    public Role findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Role.class, id);
    }

    public List<Role> findAll(){
        return (List<Role>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Role").list();
    }
}
