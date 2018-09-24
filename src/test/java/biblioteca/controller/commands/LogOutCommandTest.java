package biblioteca.controller.commands;

import biblioteca.models.Library;
import biblioteca.models.User;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LogOutCommandTest {
    private StdOut stdOut;
    private StdIn stdIn;
    private LogOutCommand logOutCommand;

    @BeforeEach
    void init() {
        stdOut = mock(StdOut.class);
        stdIn = mock(StdIn.class);
        logOutCommand = new LogOutCommand();
    }

    @DisplayName("should print succesfully logged out message")
    @Test
    void shouldPrintSuccessMessage() {
        List<User> users = new ArrayList<>();
        StdOut stdOut = mock(StdOut.class);
        StdIn stdIn = mock(StdIn.class);
        User user1 = new User("123-4567", "12346", null);
        users.add(user1);

        Library library = new Library(new ArrayList<>(), users);
        LogOutCommand logOutCommand = new LogOutCommand();
        logOutCommand.perform(library, stdOut, stdIn);
        verify(stdOut).print("You have been successfully Logged out!");
    }

    @DisplayName("should call library's logout function")
    @Test
    void shouldCallLibraryLogOutFunction() {

        Library library = Mockito.mock(Library.class);
        logOutCommand.perform(library, stdOut, stdIn);
        verify(library).logout();
    }
}