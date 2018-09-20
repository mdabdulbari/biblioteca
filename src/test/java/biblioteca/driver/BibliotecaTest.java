package biblioteca.driver;

import biblioteca.Helpers;
import biblioteca.controller.InitializeApplication;
import biblioteca.controller.MainMenu;
import biblioteca.models.Library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import biblioteca.view.StdOut;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BibliotecaTest {
    @DisplayName("should print 'Welcome to biblioteca when the application starts")
    @Test
    void shouldPrintWelcomeMessage() {
        StdOut stdOut = mock(StdOut.class);
        MainMenu mainMenu = mock(MainMenu.class);
        InitializeApplication initializeApplication = new InitializeApplication(stdOut, mainMenu);
        initializeApplication.run();
        verify(mainMenu).displayOptions();
    }

    @DisplayName("should return list of books")
    @Test
    void shouldReturnListOfBooks() {
        Helpers helpers = new Helpers();
        Library library = helpers.createLibraryWithBooks();
        List<String> bookTitles = new ArrayList<>();
        bookTitles.add("I Hate      Abdul       2018");
        bookTitles.add("Thiss      Bari       2018");
        bookTitles.add("Assignment      Mohammad       2018");
        assertEquals(bookTitles, library.getBookDetails());
    }
}