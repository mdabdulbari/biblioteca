package biblioteca;

import biblioteca.models.Library;

import biblioteca.models.Book;

import java.util.ArrayList;
import java.util.List;


public class Helpers {
    public Library createLibraryWithBooks() {
        List<Book> books = new ArrayList<>();

        Book gameOfThrones = new Book("Game Of Thrones");
        Book harryPotter = new Book("Harry Potter");
        Book headFirstJava = new Book("Head First Java");
        Book iHate = new Book("I Hate");
        Book thiss = new Book("Thiss");
        Book assignment = new Book("Assignment");

        books.add(gameOfThrones);
        books.add(harryPotter);
        books.add(headFirstJava);
        books.add(iHate);
        books.add(thiss);
        books.add(assignment);

        return new Library(books);
    }
}
