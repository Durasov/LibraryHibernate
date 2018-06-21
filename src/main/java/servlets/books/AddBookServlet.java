package servlets.books;

import dao.BookDAO;
import dao.BookshelfDAO;
import dao.impl.BookDAOImpl;
import dao.impl.BookshelfDAOImpl;
import entity.BookEntity;
import entity.BookshelfEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookEntity bookEntity = new BookEntity();
        bookEntity.getBookshelfByIdBs();
        BookshelfDAO bookshelfDAO = new BookshelfDAOImpl();
        List<BookshelfEntity> bookshelfEntityList = bookshelfDAO.getBookshelfs();
        req.getSession().setAttribute("bookshelf", bookshelfEntityList);
        req.getRequestDispatcher("addbook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookEntity bookEntity = new BookEntity();
        BookshelfEntity bookshelfEntity1 = new BookshelfEntity();

        String requestEnc="ISO-8859-1";
        String clientEnc=req.getParameter("charset");
        if(clientEnc==null) clientEnc="Cp1251";

        String book_name = req.getParameter("book_name");
        String genre = req.getParameter("genreSelector");

        if(book_name!=null && genre!=null) {
            book_name = new String(book_name.getBytes(requestEnc), clientEnc);
            genre = new String(genre.getBytes(requestEnc), clientEnc);
            HttpSession session = req.getSession();
            BookDAO bookDAO = new BookDAOImpl();
            BookshelfDAO bookshelfDAO = new BookshelfDAOImpl();

            List<BookshelfEntity> bookshelfEntity = bookshelfDAO.getBookshelfs(genre);
            bookshelfEntity1 = bookshelfEntity.get(0);
            bookDAO.insertBook(book_name,bookshelfEntity1);
            resp.sendRedirect("/allbooks");
        }
    }
}
