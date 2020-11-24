package dao;

import models.Question;
import utils.HibernateSessionFactoryUtil;

import java.util.List;


public class QuestionDao extends Dao<Question> {
    public Question findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Question.class, id);
    }

    public List<Question> findAll(){
        return (List<Question>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Question").list();
    }
}
