package biblioteca.models;

import java.util.List;

public class Library {
    List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return books.toString();
    }
}
