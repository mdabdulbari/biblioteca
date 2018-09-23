package biblioteca.controller.commands;

import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

public class ReturnBookCommand implements Command {
    @Override
    public void perform(Library library, StdOut stdOut, StdIn stdIn) {
        stdOut.print("Please enter the item you want to return: ");
        String itemReturning = stdIn.takeString();
        if (!library.returnLibraryItem(itemReturning)) {
            stdOut.print("That is not a valid item to return.");
        } else stdOut.print("Thank you for returning.");
    }
}
