package servlets.booksshelf;

import dao.BookshelfDAO;
import dao.impl.BookshelfDAOImpl;
import entity.BookEntity;
import entity.BookshelfEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookshelf")
public class BookshelfListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookshelfDAO bookshelfDAO = new BookshelfDAOImpl();
        List<BookshelfEntity> bookshelfEntities = bookshelfDAO.getBookshelfs();
        req.getSession().setAttribute("bookshelf", bookshelfEntities);
        req.getRequestDispatcher("bookshelf.jsp").forward(req,resp);
    }
}
