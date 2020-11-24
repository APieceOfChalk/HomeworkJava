package dao;

import models.Subject;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class SubjectDao extends Dao<Subject> {
    public Subject findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Subject.class, id);
    }

    public List<Subject> findAll(){
        return (List<Subject>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Subject").list();
    }
}
