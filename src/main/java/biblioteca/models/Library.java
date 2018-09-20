package biblioteca.models;

import java.util.List;
import java.util.stream.Collectors;

public class Library {
    List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<String> getTitles() {
        return this.books.stream().map(Book::toString).collect(Collectors.toList());
    }
}
