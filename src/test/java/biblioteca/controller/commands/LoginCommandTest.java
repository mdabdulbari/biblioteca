package biblioteca.controller.commands;

import biblioteca.models.Library;
import biblioteca.models.User;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class LoginCommandTest {
    private StdOut stdOut;
    private StdIn stdIn;
    private Library library;
    private LoginCommand loginCommand;

    @BeforeEach
    void init() {
        List<User> users = new ArrayList<>();
        stdOut = mock(StdOut.class);
        stdIn = mock(StdIn.class);
        User user1 = new User("123-4567", "12346");
        users.add(user1);

        library = new Library(new ArrayList<>(), users);
        loginCommand = new LoginCommand();
    }

    @DisplayName("should ask for library number and password while logging in")
    @Test
    void shouldAskForCredentialsWhileLoggingIn() {
        when(stdIn.takeInteger()).thenReturn(1).thenReturn(4);
        when(stdIn.takeString()).thenReturn("123").thenReturn("asdf");
        loginCommand.perform(library, stdOut, stdIn);
        verify(stdOut).print("Please enter your library number: ");
        verify(stdOut).print("Please enter your password: ");
    }

    @DisplayName("should print invalid credentials for user invalid")
    @Test
    void shouldReturnInvalidCredentialsMessage() {
        when(stdIn.takeString()).thenReturn("123-4567").thenReturn("1234");
        loginCommand.perform(library, stdOut, stdIn);
        verify(stdOut).print("Invalid credentials");
    }

    @DisplayName("should print login successful for user invalid")
    @Test
    void shouldReturnLoginSuccessfulMessage() {

        when(stdIn.takeString()).thenReturn("123-4567").thenReturn("12346");
        loginCommand.perform(library, stdOut, stdIn);
        verify(stdOut).print("Login Successful");
    }
}