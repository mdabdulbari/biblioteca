package biblioteca.models;

import java.util.List;
import java.util.stream.Collectors;

public class Library {
    List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<String> getBookDetails() {
        return this.books.stream().map(Book::getDetails).collect(Collectors.toList());
    }
}
