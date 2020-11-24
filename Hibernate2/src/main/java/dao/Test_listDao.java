package dao;

import models.Test_list;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class Test_listDao extends Dao<Test_list> {
    public Test_list findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Test_list.class, id);
    }

    public List<Test_list> findAll(){
        return (List<Test_list>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Test_list").list();
    }
}
