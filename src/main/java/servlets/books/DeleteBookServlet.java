package servlets.books;

import dao.BookDAO1;

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
        BookDAO1 bookDAO1 = new BookDAO1();
        if (req.getParameter("book_name") != null) {
            String book_name = req.getParameter("book_name");
            bookDAO1.deleteBook(book_name);
        }
        resp.sendRedirect("books");
    }
}
