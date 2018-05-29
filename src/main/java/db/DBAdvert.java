package db;

import models.Advert;
import models.Category;
import models.Comment;
import models.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBAdvert {

    private static Transaction transaction;
    private static Session session;

    public static List<Comment> findAllCommentsForAdvert(Advert advert){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Comment> comments = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Comment.class);
            cr.add(Restrictions.eq("advert", advert));
            comments = cr.list();

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return comments;
    }

    public static User findUserForAdvert(Advert advert){
        session = HibernateUtil.getSessionFactory().openSession();
        User user = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(User.class);
            cr.add(Restrictions.eq("advert", advert));
            user = (User)cr.uniqueResult();

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    public static List<Advert> findAdvertsByCategory(Category category){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Advert> adverts = null;
        try {
            Criteria cr = session.createCriteria(Advert.class);
            Disjunction or = Restrictions.disjunction();
            or.add(Restrictions.eq("category", category));
            cr.add(or);
            adverts = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return adverts;
    }

    public static List<Comment> findCommentsForAdvert(Advert advert){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Comment> comments = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Comment.class);
            cr.add(Restrictions.eq("advert", advert));
            comments = cr.list();

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return comments;
    }
}
