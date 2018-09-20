package biblioteca.models;

import biblioteca.Helpers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {
    @DisplayName("should return string of two books when toString is called called on a library")
    @Test
    void shouldPrintTwoBooks() {
        Helpers helpers = new Helpers();
        Library library = helpers.createLibraryWithBooks();
        List<String> books = new ArrayList<>();

        books.add("Game Of Thrones");
        books.add("Harry Potter");
        books.add("Head First Java");
        books.add("I Hate");
        books.add("Thiss");
        books.add("Assignment");

        assertEquals(books.toString(), library.toString());
    }
}