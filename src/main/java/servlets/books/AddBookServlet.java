package servlets.books;

import dao.BookDAO1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String book_name;

        if (req.getParameter("book_name") != null &&
                req.getParameter("team_name") != null &&
                req.getParameter("team_country") != null) {
            HttpSession session = req.getSession();
            book_name = req.getParameter("book_name");
            BookDAO1 bookDAO1 = new BookDAO1();
            //TeamDAO teamDAO = (TeamDAO) session.getAttribute("teamDAO");
            //BookEntity bookEntity = new BookEntity(team_id,team_name,team_country);
            bookDAO1.insertBook(book_name);
            resp.sendRedirect("/books");
        }
    }
}
