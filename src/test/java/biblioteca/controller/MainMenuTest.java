package biblioteca.controller;

import biblioteca.view.StdOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MainMenuTest {
    private StdOut stdOut;
    private MainMenu mainMenu;

    @BeforeEach
    void init() {
        stdOut = mock(StdOut.class);
        mainMenu = new MainMenu(stdOut);
    }

    @DisplayName("should display List of Books as an option on the main menu")
    @Test
    void shouldDisplayListOfOptions() {
        InitializeApplication initializeApplication = new InitializeApplication(stdOut, mainMenu);
        initializeApplication.run();
        verify(stdOut).print("List of Books");
    }

}