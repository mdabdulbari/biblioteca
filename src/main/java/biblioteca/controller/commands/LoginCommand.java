package biblioteca.controller.commands;

import biblioteca.models.ItemType;
import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

public class LoginCommand implements Command {
    public LoginCommand(ItemType itemType) {
    }

    @Override
    public void perform(Library library, StdOut stdOut, StdIn stdIn) {
    }
}
