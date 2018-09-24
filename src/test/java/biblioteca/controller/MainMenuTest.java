package biblioteca.controller;

import biblioteca.common.Helpers;
import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

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
        library = helpers.createLibrary();
        mainMenu = new MainMenu(stdOut, library, stdIn);
    }

    @DisplayName("should display all the options on the main menu")
    @Test
    void shouldDisplayListOfOptions() {
        when(stdIn.takeInteger()).thenReturn(2).thenReturn(4);
        InitializeApplication initializeApplication = new InitializeApplication(stdOut, mainMenu);
        initializeApplication.run();
        verify(stdOut).print("Welcome to biblioteca");
        verify(stdOut, times(2))
                .print("1) Login     2) List books     3) List Movies     4) Quit     ");
    }

    @DisplayName("should print please Select a valid option when an invalid option is given")
    @Test
    void invalidOption() {
        when(stdIn.takeInteger()).thenReturn(7).thenReturn(4);
        InitializeApplication initializeApplication = new InitializeApplication(stdOut, mainMenu);
        initializeApplication.run();
        verify(stdOut).print("Please select a valid option!");
    }
}
