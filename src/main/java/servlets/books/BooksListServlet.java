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

@WebServlet("/books")
public class BooksListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("idBs") != null) {
            int idBs = Integer.parseInt(req.getParameter("idBs"));
            BookDAO bookDAO = new BookDAOImpl();
            List<BookEntity> bookEntities = bookDAO.getBooks(idBs);
            req.getSession().setAttribute("books", bookEntities);
            req.getRequestDispatcher("books.jsp").forward(req,resp);
        }
    }
}
