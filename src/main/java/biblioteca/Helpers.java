package biblioteca;

import biblioteca.models.Library;

import biblioteca.models.Book;

import java.util.ArrayList;
import java.util.List;


public class Helpers {
    public Library createLibraryWithBooks() {
        List<Book> books = new ArrayList<>();

        Book iHate = new Book("I Hate");
        Book thiss = new Book("Thiss");
        Book assignment = new Book("Assignment");

        books.add(iHate);
        books.add(thiss);
        books.add(assignment);

        return new Library(books);
    }
}
