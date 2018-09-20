package biblioteca;

import biblioteca.models.Library;

import biblioteca.models.Book;

import java.util.ArrayList;
import java.util.List;


public class Helpers {
    public Library createLibraryWithBooks() {
        List<Book> books = new ArrayList<>();

        Book iHate = new Book("I Hate", "Abdul", 2018);
        Book thiss = new Book("Thiss", "Bari", 2018);
        Book assignment = new Book("Assignment", "Mohammad", 2018);

        books.add(iHate);
        books.add(thiss);
        books.add(assignment);

        return new Library(books);
    }
}
