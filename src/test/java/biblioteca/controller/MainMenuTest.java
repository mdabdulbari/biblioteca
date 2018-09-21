package biblioteca.controller;

import biblioteca.Helpers;
import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MainMenuTest {
    private StdOut stdOut;
    private StdIn stdIn;
    private MainMenu mainMenu;
    private Library library;

    @BeforeEach
    void init() {
        stdOut = mock(StdOut.class);
        stdIn = mock(StdIn.class);
        Helpers helpers = new Helpers();
        library = helpers.createLibraryWithBooks();
        mainMenu = new MainMenu(stdOut, library, stdIn);
    }

    @DisplayName("should display List of Books as an option on the main menu")
    @Test
    void shouldDisplayListOfOptions() {
        when(stdIn.takeInteger()).thenReturn(1);
        InitializeApplication initializeApplication = new InitializeApplication(stdOut, mainMenu, stdIn);
        initializeApplication.run();
        verify(stdOut).print("1) List books");
    }

    @DisplayName("should print please Select a valid option when an invalid option is given")
    @Test
    void invalidOption() {
        when(stdIn.takeInteger()).thenReturn(3);
        StdIn stdIn = new StdIn();
        InitializeApplication initializeApplication = new InitializeApplication(stdOut, mainMenu, stdIn);
        initializeApplication.run();
        verify(stdOut).print("Please select a valid option!");
    }
}