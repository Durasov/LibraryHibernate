package dao.impl;

import entity.BookEntity;
import dao.BookDAO;
import entity.BookshelfEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private Session createHibernateSession(){
        SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }

    public void save(BookEntity book) {
        Session session = createHibernateSession();
        Transaction tx = session.beginTransaction();
        session.persist(book);
        tx.commit();
        session.close();
    }

    public List<BookEntity> getBooks(int idB) {
        Session session = createHibernateSession();
        Transaction tx = session.beginTransaction();
        List<BookEntity> books = new ArrayList<BookEntity>();
        List<BookshelfEntity> bookshelfEntities = session.createQuery("from BookshelfEntity").list();
        BookshelfEntity bookshelfEntity = new BookshelfEntity();
        bookshelfEntity.getBooksByIdBs();
        for(BookshelfEntity bookshelfEntity1: bookshelfEntities){
            if(bookshelfEntity1.getIdBs()==idB){
                Hibernate.initialize(bookshelfEntity1.getBooksByIdBs());
                for(BookEntity b: bookshelfEntity1.getBooksByIdBs()){
                    books.add(b);
                }
            }
        }
        tx.commit();
        session.close();
        return books;
    }
}
