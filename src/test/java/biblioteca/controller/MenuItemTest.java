package biblioteca.controller;

import biblioteca.Helpers;
import biblioteca.models.Library;
import biblioteca.view.StdOut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MenuItemTest {
    @DisplayName("should return List books when getter is called on LIST_BOOKS enum")
    @Test
    void shouldReturnListBooks() {
        assertEquals("List books", MenuItem.LIST_BOOKS.getValue());
    }

    @DisplayName("should return Quit when getter is called on QUIT enum")
    @Test
    void getValue() {
        assertEquals("Quit", MenuItem.QUIT.getValue());
    }

    @DisplayName("should print list of books when act method is called on LIST_BOOKS enum")
    @Test
    void shouldPrintListOfBooks() {
        Helpers helpers = new Helpers();
        Library library = helpers.createLibraryWithBooks();
        StdOut stdOut = mock(StdOut.class);
        MenuItem.LIST_BOOKS.act(library, stdOut);
        verify(stdOut).print("---Here are all the books in the library---");
        verify(stdOut).print("I Hate                                                      Abdul               2018                ");
        verify(stdOut).print("Thiss                                                       Bari                2018                ");
        verify(stdOut).print("Assignment                                                  Mohammad            2018                ");
    }
}