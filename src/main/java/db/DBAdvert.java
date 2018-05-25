package db;

import models.Advert;
import models.Comment;
import models.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
}
