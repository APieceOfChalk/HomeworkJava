package dao;

import models.User;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class UserDao extends Dao<User> {
    public User findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public List<User> findAll(){
        return (List<User>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
    }
    public List<User> getTeachers() {
        List<User> users = findAll();
        ArrayList<User> teachers = new ArrayList<User>();
       for (User u: users) {
          if(  u.getRole().getRow_id() == 2) {
              teachers.add(u);
          }
       }
       return teachers;
    }
    public List<User> getStudents() {
        List<User> users = findAll();
        ArrayList<User> students = new ArrayList<User>();
        for (User u: users) {
            if(  u.getRole().getRow_id() == 1) {
                students.add(u);
            }
        }
        return students;
    }
}
