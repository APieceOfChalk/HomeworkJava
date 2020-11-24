package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class Dao<TEntity> {
    public void save(TEntity model){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(model);
        tx1.commit();
        session.close();
    }

    public void update(TEntity model){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(model);
        tx1.commit();
        session.close();
    }

    public void delete(TEntity model) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(model);
        tx1.commit();
        session.close();
    }
}