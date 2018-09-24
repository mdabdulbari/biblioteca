package biblioteca.controller.commands;

import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

public class LoginCommand implements Command {
    @Override
    public void perform(Library library, StdOut stdOut, StdIn stdIn) {
        stdOut.print("Please enter your library number: ");
        String libraryNumber = stdIn.takeString();
        stdOut.print("Please enter your password: ");
        String password = stdIn.takeString();
        if (!library.authenticate(libraryNumber, password)) {
            stdOut.print("Invalid credentials");
        } else {
            stdOut.print("Login Successful");
        }
    }
}
