package servlets.books;

import dao.BookDAO;
import dao.impl.BookDAOImpl;
import entity.BookEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allbooks")
public class AllBooksListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDAO bookDAO = new BookDAOImpl();
        List<BookEntity> bookEntities = bookDAO.getAllBooks();
        req.getSession().setAttribute("allbooks", bookEntities);
        req.getRequestDispatcher("allbooks.jsp").forward(req,resp);

    }
}
