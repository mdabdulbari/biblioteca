package biblioteca.controller.commands;

import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

public interface Command {
    void perform(Library library, StdOut stdOut, StdIn stdIn);
}
