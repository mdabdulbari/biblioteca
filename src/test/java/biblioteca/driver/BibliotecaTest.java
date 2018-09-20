package biblioteca.driver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import biblioteca.view.StdOut;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BibliotecaTest {
    @DisplayName("should print 'Welcome to biblioteca when the application starts")
    @Test
    void shouldPrintWelcomeMessage() {
        StdOut stdOut = mock(StdOut.class);
        InitializeApplication initializeApplication = new InitializeApplication(stdOut);
        initializeApplication.run();
        verify(stdOut).print("Welcome to biblioteca");
    }
}