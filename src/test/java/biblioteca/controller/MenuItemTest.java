package biblioteca.controller;

import biblioteca.Helpers;
import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void shouldReturnQuit() {
        assertEquals("Quit", MenuItem.QUIT.getValue());
    }

    @DisplayName("should return Quit when getter is called on CHECKOUT_BOOK enum")
    @Test
    void shouldReturnCheckout() {
        assertEquals("Checkout", MenuItem.CHECKOUT_BOOK.getValue());
    }

    @DisplayName("should print perform of books when perform method is called on LIST_BOOKS enum")
    @Test
    void shouldPrintListOfBooks() {
        Helpers helpers = new Helpers();
        Library library = helpers.createLibraryWithBooks();
        StdOut stdOut = mock(StdOut.class);
        StdIn stdIn = mock(StdIn.class);
        MenuItem.LIST_BOOKS.perform(library, stdOut, stdIn);
        verify(stdOut).print("------------------------Here is the list of all the books in the library----------------------");
        verify(stdOut).print("I Hate                                                      Abdul                         2018                          ");
        verify(stdOut).print("Thiss                                                       Bari                          2018                          ");
        verify(stdOut).print("Assignment                                                  Mohammad                      2018                          ");
    }

    @DisplayName("should print Thank you message on successful checkout")
    @Test
    void shouldPrintThankYouMessage() {
        Helpers helpers = new Helpers();
        Library library = helpers.createLibraryWithBooks();
        StdOut stdOut = mock(StdOut.class);
        StdIn stdIn = mock(StdIn.class);
        when(stdIn.takeString()).thenReturn("Thiss");
        MenuItem.CHECKOUT_BOOK.perform(library, stdOut, stdIn);
        verify(stdOut).print("Thank you! Enjoy");
    }
}