package biblioteca.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<Book> checkedOutBooks;

    public Library(List<Book> books) {
        this.books = books;
        checkedOutBooks = new ArrayList<>();
    }

    public List<String> getBookDetails() {
        return this.books.stream().map(Book::getDetails).collect(Collectors.toList());
    }

    public boolean checkout(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                books.remove(book);
                checkedOutBooks.add(book);
                return true;
            }
        }
        return false;
    }

    boolean contains(Book book) {
        return books.contains(book);
    }

    boolean isCheckedOut(Book book) {
        return checkedOutBooks.contains(book);
    }
}
