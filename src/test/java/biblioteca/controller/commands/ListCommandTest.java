package biblioteca.controller.commands;

import biblioteca.common.Helpers;
import biblioteca.controller.MenuItem;
import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ListCommandTest {
    @DisplayName("should print list of books when perform method is called")
    @Test
    void shouldPrintListOfBooks() {
        Helpers helpers = new Helpers();
        Library library = helpers.createLibrary();
        StdOut stdOut = mock(StdOut.class);
        StdIn stdIn = mock(StdIn.class);
        MenuItem.LIST_BOOKS.perform(library, stdOut, stdIn);
        verify(stdOut).print("------------------------Here is the list of all the books in the library----------------------");
        verify(stdOut).print("I Hate                                                      Abdul                         2018                          ");
        verify(stdOut).print("Thiss                                                       Bari                          2018                          ");
    }

    @DisplayName("should print list of movies")
    @Test
    void shouldPrintListOfMovies() {
        Helpers helpers = new Helpers();
        Library library = helpers.createLibrary();
        StdOut stdOut = mock(StdOut.class);
        StdIn stdIn = mock(StdIn.class);
        MenuItem.LIST_MOVIES.perform(library, stdOut, stdIn);
        verify(stdOut).print("--------------------------------------------Here are all the movies in the library--------------------------------------------");
        verify(stdOut).print("The Shawshank Redemption                                    1994                          Frank Darabont                9.3                           ");
        verify(stdOut).print("The Incredibles                                             1994                          Frank Darabont                9.3                           ");
    }
}