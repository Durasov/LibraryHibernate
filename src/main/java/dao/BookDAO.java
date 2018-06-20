package dao;

import entity.BookEntity;

import java.util.List;

public interface BookDAO {
    public void save (BookEntity book);
    public List<BookEntity> getBooks(int idB);
}
