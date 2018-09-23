package biblioteca;

import biblioteca.models.Library;

import biblioteca.models.Book;
import biblioteca.models.LibraryItem;
import biblioteca.models.Movie;

import java.util.ArrayList;
import java.util.List;


public class Helpers {
    public Library createLibraryWithBooks() {
        List<LibraryItem> libraryItems = new ArrayList<>();

        Book iHate = new Book("I Hate", "Abdul", 2018);
        Book thiss = new Book("Thiss", "Bari", 2018);
        Book assignment = new Book("Assignment", "Mohammad", 2018);

        Movie shawshank = new Movie("The Shawshank Redemption", 1994, "Frank Darabont", 9.3);
        Movie incredibles = new Movie("The Incredibles", 1994, "Frank Darabont", 9.3);

        libraryItems.add(iHate);
        libraryItems.add(thiss);
        libraryItems.add(assignment);
        libraryItems.add(shawshank);
        libraryItems.add(incredibles);

        return new Library(libraryItems);
    }
}
