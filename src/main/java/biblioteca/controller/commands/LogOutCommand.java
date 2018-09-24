package biblioteca.controller.commands;

import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

public class LogOutCommand implements Command {
    @Override
    public void perform(Library library, StdOut stdOut, StdIn stdIn) {
        library.logout();
        stdOut.print("You have been successfully Logged out!");
    }
}
