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
import java.io.IOException;
import java.util.List;

@WebServlet("/editBook")
public class EditBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookEntity bookEntity;
        BookshelfEntity bookshelfEntity;
        BookDAO bookDAO = new BookDAOImpl();
        BookshelfDAO bookshelfDAO = new BookshelfDAOImpl();
        if (req.getParameter("idB") != null) {
            int idB = Integer.parseInt(req.getParameter("idB"));
            List<BookEntity> bookEntities = bookDAO.getBook(idB);
            bookEntity = bookEntities.get(0);
            bookshelfEntity = bookEntity.getBookshelfByIdBs();
            List<BookshelfEntity> bookshelfEntities = bookshelfDAO.getBookshelfs();
            req.getSession().setAttribute("bookToEdit", bookEntity);
            req.getSession().setAttribute("bookToEditbookshelf", bookshelfEntity);
            req.getSession().setAttribute("bookshelf", bookshelfEntities);
        }
        req.getRequestDispatcher("editbook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookEntity bookEntity;
        BookshelfEntity bookshelfEntity;
        BookDAO bookDAO = new BookDAOImpl();
        BookshelfDAO bookshelfDAO = new BookshelfDAOImpl();

        String requestEnc="ISO-8859-1";
        String clientEnc=req.getParameter("charset");
        if(clientEnc==null) clientEnc="Cp1251";

        String book_name = req.getParameter("book_name");
        String genre = req.getParameter("genreSelector");

        if(book_name!=null && genre!=null) {
            book_name = new String(book_name.getBytes(requestEnc), clientEnc);
            genre = new String(genre.getBytes(requestEnc), clientEnc);

            bookEntity = (BookEntity) req.getSession().getAttribute("bookToEdit");

            List<BookshelfEntity> bookshelfEntities = bookshelfDAO.getBookshelfs(genre);
            bookshelfEntity = bookshelfEntities.get(0);
            ((BookDAOImpl) bookDAO).updateBook(bookEntity.getIdB(),book_name,bookshelfEntity);
            resp.sendRedirect("/allbooks");
        }
    }
}
