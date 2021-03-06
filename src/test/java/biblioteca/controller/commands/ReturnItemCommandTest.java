package biblioteca.controller.commands;

import biblioteca.controller.MenuItem;
import biblioteca.models.*;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReturnItemCommandTest {
    private Library library;
    private Book book1;
    private Book book2;
    private ReturnItemCommand returnItemCommand;
    private StdOut stdOut;
    private StdIn stdIn;
    private ArrayList<User> users;
    private User user1;

    @BeforeEach
    void init() {
        List<LibraryItem> libraryItems = new ArrayList<>();
        book1 = new Book("book1", "Bari", 2001);
        book2 = new Book("book2", "Bari", 2002);

        libraryItems.add(book1);
        libraryItems.add(book2);

        UserInformation userInformation = mock(UserInformation.class);
        users = new ArrayList<>();
        user1 = new User("111-1111", "asdfasdf", userInformation);
        users.add(user1);

        library = new Library(libraryItems, users);
        returnItemCommand = new ReturnItemCommand();

        stdOut = mock(StdOut.class);
        stdIn = mock(StdIn.class);
    }

    @DisplayName("a returned book should be added to the books in library")
    @Test
    void shouldAddReturnedBookInTheLibrary() {
        library.authenticate("111-1111", "asdfasdf");
        library.checkout("book1");
        when(stdIn.takeString()).thenReturn("book1");
        MenuItem.RETURN.perform(library, stdOut, stdIn);
        assertTrue(library.contains(book1));
    }

    @DisplayName("should display successful return message")
    @Test
    void shouldReturnSuccessfulReturnMessage() {
        library.authenticate("111-1111", "asdfasdf");
        library.checkout("book1");
        when(stdIn.takeString()).thenReturn("book1");
        MenuItem.RETURN.perform(library, stdOut, stdIn);
        verify(stdOut).print("Thank you for returning.");
    }

    @DisplayName("should display unsuccessful return message")
    @Test
    void shouldReturnUnSuccessfulReturnMessage() {
        library.authenticate("111-1111", "asdfasdf");
        library.checkout("book1");
        when(stdIn.takeString()).thenReturn("book123");
        MenuItem.RETURN.perform(library, stdOut, stdIn);
        verify(stdOut).print("That is not a valid item to return.");
    }
}