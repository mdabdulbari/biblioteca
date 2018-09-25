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

    @DisplayName("should display the options for user not logged in on the main menu")
    @Test
    void shouldDisplayListOfOptions() {
        when(stdIn.takeInteger()).thenReturn(0);
        InitializeApplication initializeApplication = new InitializeApplication(stdOut, mainMenu);
        initializeApplication.run();
        verify(stdOut).print("Welcome to biblioteca");
        verify(stdOut)
                .print("0) Quit     1) Login     2) List books     3) List Movies     ");
    }

    @DisplayName("should print please Select a valid option when an invalid option is given")
    @Test
    void invalidOption() {
        when(stdIn.takeInteger()).thenReturn(7).thenReturn(0);
        InitializeApplication initializeApplication = new InitializeApplication(stdOut, mainMenu);
        initializeApplication.run();
        verify(stdOut).print("Please select a valid option!");
    }

    @DisplayName("should display options for logged in user")
    @Test
    void shouldDisplayOptionsForLoggedInUser() {
        when(stdIn.takeInteger()).thenReturn(1).thenReturn(0);
        when(stdIn.takeString()).thenReturn("111-1111").thenReturn("asdfasdf");
        mainMenu.displayOptionsAndAskForOption();
        verify(stdOut)
                .print("0) Quit     1) List books     2) List Movies     3) Checkout     4) Return     5) My Details     6) Log Out     ");
    }
}
