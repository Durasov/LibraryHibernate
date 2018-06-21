package servlets.books;

import dao.BookDAO;
import dao.impl.BookDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        BookDAO bookDAO = new BookDAOImpl();
        if (req.getParameter("idB") != null) {
            int idB = Integer.parseInt(req.getParameter("idB"));
            bookDAO.deleteBook(idB);
        }
        resp.sendRedirect("allbooks");
    }
}
