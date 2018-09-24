package biblioteca.controller.commands;

import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

import java.util.List;

public class DisplayDetailsCommand implements Command {
    @Override
    public void perform(Library library, StdOut stdOut, StdIn stdIn) {
        List<String> userDetails = library.getCurrentUser().getInformation();
        stdOut.print("--------------------------------------");
        stdOut.print("Name: " + userDetails.get(0));
        stdOut.print("Email: " + userDetails.get(1));
        stdOut.print("Contact Number: " + userDetails.get(2));
        stdOut.print("--------------------------------------");
    }
}
