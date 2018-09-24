package biblioteca.controller.commands;


import biblioteca.common.Helpers;
import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class DisplayDetailsCommandTest {
    @DisplayName("should print user information")
    @Test
    void shouldPrintUserInformation() {
        StdOut stdOut = mock(StdOut.class);
        StdIn stdIn = mock(StdIn.class);
        Helpers helpers = new Helpers();
        Library library = helpers.createLibrary();

        DisplayDetailsCommand displayDetailsCommand = new DisplayDetailsCommand();
        library.authenticate("111-1111", "asdfasdf");
        displayDetailsCommand.perform(library, stdOut, stdIn);
        verify(stdOut, times(2))
                .print("--------------------------------------");
        verify(stdOut).print("Name: asdf");
        verify(stdOut).print("Email: asdf@gmail.com");
        verify(stdOut).print("Contact Number: 1234123412");
    }

}