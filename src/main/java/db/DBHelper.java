package db;

import models.Advert;
import models.User;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void save(Object object) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

//    public static <T> void deleteAll(Class classType){
//        session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            transaction = session.beginTransaction();
//            Criteria cr = session.createCriteria(classType);
//            List<T> results = cr.list();
//            for (T result : results){
//                session.delete(result);
//            }
//        } catch (HibernateException e){
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }

    public static void deleteAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "DELETE FROM " + classType.getName();
            transaction = session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void update(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(classType);
            results = cr.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static <T> T find(int id, Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(classType);
            cr.add(Restrictions.eq("id", id));
            result = (T)cr.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println(result);
        return result;
    }

    public static List<Advert> search(String string){
        session = HibernateUtil.getSessionFactory().openSession();
            List<Advert> results = null;
        try {
            Criteria cr = session.createCriteria(Advert.class);
            cr.add(Restrictions.ilike("title", "%" + string + "%", MatchMode.ANYWHERE));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        } return results;

    }





}

