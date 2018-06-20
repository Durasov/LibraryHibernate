import dao.BookDAO1;

public class Main {

    public static void main(final String[] args) throws Exception {
        BookDAO1 bookDAO1 = new BookDAO1();
        bookDAO1.insertBook("test");
    }
}