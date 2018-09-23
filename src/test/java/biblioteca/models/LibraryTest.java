package biblioteca.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;
    private List<String> bookDetails;
    private Book iHate;
    private Book thiss;
    private Book assignment;

    @BeforeEach
    void init() {
        iHate = new Book("I Hate", "Abdul", 2018);
        thiss = new Book("Thiss", "Bari", 2018);
        assignment = new Book("Assignment", "Mohammad", 2018);

        bookDetails = new ArrayList<>();
        bookDetails.add("I Hate,Abdul,2018");
        bookDetails.add("Thiss,Bari,2018");
        bookDetails.add("Assignment,Mohammad,2018");


        List<LibraryItem> libraryItems = new ArrayList<>();

        libraryItems.add(iHate);
        libraryItems.add(thiss);
        libraryItems.add(assignment);

        library = new Library(libraryItems);
    }

    @DisplayName("should return string of three books when toString is called called on a library")
    @Test
    void shouldPrintThreeBooks() {
        assertEquals(bookDetails, library.getList(ItemType.BOOK));
    }

    @DisplayName("should remove I Hate book from the library")
    @Test
    void shouldRemoveAbook() {
        library.checkout("I Hate");
        assertFalse(library.contains(iHate));
        assertTrue(library.isCheckedOut(iHate));
    }

    @DisplayName("should remove Assignment book from the library")
    @Test
    void shouldRemoveAnotherbook() {
        library.checkout("Assignment");
        assertFalse(library.contains(assignment));
        assertTrue(library.isCheckedOut(assignment));
    }

    @DisplayName("should add Assignment book back to the library")
    @Test
    void shouldAddABookToTheLibrary() {
        library.checkout("Assignment");
        assertFalse(library.contains(assignment));
        library.returnLibraryItem("Assignment");
        assertTrue(library.contains(assignment));
    }
}