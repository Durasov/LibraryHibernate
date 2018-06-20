package dao.impl;

import entity.BookshelfEntity;
import dao.BookshelfDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class BookshelfDAOImpl implements BookshelfDAO {
    private Session createHibernateSession(){
        SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }
    public void save(BookshelfEntity bookshelfEntity) {
        Session session = createHibernateSession();
        Transaction tx = session.beginTransaction();
        session.persist(bookshelfEntity);
        tx.commit();
        session.close();
    }

    public List<BookshelfEntity> getBookshelfs() {
        Session session = createHibernateSession();
        Transaction tx = session.beginTransaction();
        String hql = "from BookshelfEntity";
        List<BookshelfEntity> bookshelfEntities = session.createQuery(hql).list();
        session.close();
        return bookshelfEntities;
    }
}
