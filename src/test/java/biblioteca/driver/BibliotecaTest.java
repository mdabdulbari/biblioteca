package biblioteca.driver;

import biblioteca.common.Helpers;
import biblioteca.controller.InitializeApplication;
import biblioteca.controller.MainMenu;
import biblioteca.models.ItemType;
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
        verify(mainMenu).displayOptionsAndAskForOption();
    }

    @DisplayName("should return perform of books")
    @Test
    void shouldReturnListOfBooks() {
        Helpers helpers = new Helpers();
        Library library = helpers.createLibrary();
        List<String> bookDetails = new ArrayList<>();
        bookDetails.add("I Hate,Abdul,2018");
        bookDetails.add("Thiss,Bari,2018");
        bookDetails.add("Assignment,Mohammad,2018");
        assertEquals(bookDetails, library.getList(ItemType.BOOK));
    }
}