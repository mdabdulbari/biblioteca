package driver;

import LibraryManagementSystem.Biblioteca;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.StdOut;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BibliotecaTest {
    @DisplayName("should print 'Welcome to Biblioteca when the application starts")
    @Test
    void shouldPrintWelcomeMessage() {
        StdOut stdOut = mock(StdOut.class);
        InitializeApplication initializeApplication = new InitializeApplication(stdOut);
        initializeApplication.run();
        verify(stdOut).print("Welcome to Biblioteca");
    }
}