package dao.impl;

import entity.BookEntity;
import dao.BookDAO;
import entity.BookshelfEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;

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

    public void insertBook(String name, BookshelfEntity bookshelfEntity){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        BookEntity bookEntity = new BookEntity();
        bookEntity.setNameB(name);
        bookEntity.setBookshelfByIdBs(bookshelfEntity);
        session.save(bookEntity);
        transaction.commit();
    }

    public void deleteBook(int idB){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete BookEntity where idB=:param");
        query.setParameter("param",idB);
        if (query.executeUpdate() > 0){
            transaction.commit();
        }
    }

    public void updateBook(int idB,String name, BookshelfEntity bookshelfEntity){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        if(session.createQuery("update BookEntity set nameB=:param, bookshelfByIdBs=:param2 where idB=:param3").setParameter("param",name).setParameter("param2",bookshelfEntity).setParameter("param3",idB).executeUpdate() > 0){
            transaction.commit();
        }
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

    public List<BookEntity> getBook(int idB) {
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from BookEntity where idB=:param");
        query.setParameter("param",idB);
        List<BookEntity> bookEntities = query.list();
        session.close();
        return bookEntities;
    }

    public List<BookEntity> getAllBooks(){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        List<BookEntity> bookEntities= session.createQuery("from BookEntity ").list();
        return bookEntities;
    }
}
