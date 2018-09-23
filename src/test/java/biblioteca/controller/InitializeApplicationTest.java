package biblioteca.controller;

import biblioteca.common.Helpers;
import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class InitializeApplicationTest {
    private StdIn stdIn;
    private StdOut stdOut;
    private Helpers helpers;
    private InitializeApplication initializeApplication;


    @BeforeEach
    void init() {
        stdOut = mock(StdOut.class);
        stdIn = mock(StdIn.class);
        helpers = new Helpers();
        Library library = helpers.createLibraryWithBooks();

        MainMenu mainMenu = new MainMenu(stdOut, library, stdIn);
        initializeApplication = new InitializeApplication(stdOut, mainMenu);
    }

    @DisplayName("should print welcome to biblioteca when run is called")
    @Test
    void shouldPrintWelcomeMessage() {
        when(stdIn.takeInteger()).thenReturn(1).thenReturn(5);
        initializeApplication.run();
        verify(stdOut).print("Welcome to biblioteca");
    }

    @DisplayName("should call displayOptionsAndAskForOption method when run method is called on initialize application")
    @Test
    void shouldCallDisplayOptionsMethod() {
        when(stdIn.takeInteger()).thenReturn(1).thenReturn(5);
        initializeApplication.run();
        verify(stdOut).print("Welcome to biblioteca");
    }
}