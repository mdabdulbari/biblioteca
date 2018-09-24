package biblioteca.controller.commands;

import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

public class CheckoutItemCommand implements Command {
    @Override
    public void perform(Library library, StdOut stdOut, StdIn stdIn) {
        stdOut.print("Please enter the book or movie you want: ");
        String bookSelected = stdIn.takeString();
        if (!library.checkout(bookSelected)) {
            stdOut.print("That item is not available.");
        } else stdOut.print("Thank you! Enjoy");
    }
}
