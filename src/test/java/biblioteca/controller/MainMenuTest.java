package biblioteca.controller;

import biblioteca.view.StdIn;
import biblioteca.view.StdOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MainMenuTest {
    private StdOut stdOut;
    private StdIn stdIn;
    private MainMenu mainMenu;

    @BeforeEach
    void init() {
        stdOut = mock(StdOut.class);
        stdIn = mock(StdIn.class);
        mainMenu = new MainMenu(stdOut, stdIn);
    }

    @DisplayName("should display List of Books as an option on the main menu")
    @Test
    void shouldDisplayListOfOptions() {
        InitializeApplication initializeApplication = new InitializeApplication(stdOut, mainMenu, stdIn);
        initializeApplication.run();
        verify(stdOut).print("1. List of Books");
    }

    @DisplayName("should print please Select a valid option when an invalid option is given")
    @Test
    void invalidOption() {
        setSystemIn("2\n");
        StdIn stdIn = new StdIn();
        InitializeApplication initializeApplication = new InitializeApplication(stdOut, mainMenu, stdIn);
        initializeApplication.run();
        verify(stdOut).print("Select a valid option!");
    }

    private void setSystemIn(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }
}