package biblioteca.controller;

import biblioteca.controller.commands.*;
import biblioteca.models.ItemType;
import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

public enum MenuItem {
    LIST_BOOKS("List books", new ListCommand(ItemType.BOOK)) {
    },

    QUIT("Quit", null) {
        @Override
        public void perform(Library library, StdOut stdOut, StdIn stdIn) {
        }
    },

    CHECKOUT_BOOK("Checkout", new CheckoutBookCommand()) {
    },

    RETURN("Return", new ReturnBookCommand()) {
    },

    LIST_MOVIES("List Movies", new ListCommand(ItemType.MOVIE)) {
    },

    LOGIN("Login", new LoginCommand(ItemType.BOOK)); {
    };

    public String getValue() {
        return displayName;
    }

    public void perform(Library library, StdOut stdOut, StdIn stdIn) {
        command.perform(library, stdOut, stdIn);
    }

    private final String displayName;
    protected Command command;

    MenuItem(String displayName, Command command) {
        this.displayName = displayName;
        this.command = command;
    }
}
