package biblioteca.models;

import biblioteca.Helpers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {
    @DisplayName("should return string of three books when toString is called called on a library")
    @Test
    void shouldPrintThreeBooks() {
        Helpers helpers = new Helpers();
        Library library = helpers.createLibraryWithBooks();
        List<String> bookDetails = new ArrayList<>();

        bookDetails.add("I Hate      Abdul       2018");
        bookDetails.add("Thiss      Bari       2018");
        bookDetails.add("Assignment      Mohammad       2018");

        assertEquals(bookDetails, library.getBookDetails());
    }
}