package dao.impl;

import entity.BookshelfEntity;
import dao.BookshelfDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

    public List<BookshelfEntity> getBookshelfs(String name) {
        Session session = createHibernateSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from BookshelfEntity where nameBs=:param");
        query.setParameter("param",name);
        List<BookshelfEntity> bookshelfEntities = query.list();
        session.close();
        return bookshelfEntities;
    }
}
