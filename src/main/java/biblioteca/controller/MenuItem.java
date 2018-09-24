package biblioteca.controller;

import biblioteca.controller.commands.*;
import biblioteca.models.ItemType;
import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

public enum MenuItem {
    LIST_BOOKS("List books", new ListCommand(ItemType.BOOK), OptionVisibility.ALWAYS) {
    },

    QUIT("Quit", null, OptionVisibility.ALWAYS) {
        @Override
        public void perform(Library library, StdOut stdOut, StdIn stdIn) {
        }
    },

    CHECKOUT_BOOK("Checkout", new CheckoutBookCommand(), OptionVisibility.LOGGED_IN) {
    },

    RETURN("Return", new ReturnBookCommand(), OptionVisibility.LOGGED_IN) {
    },

    LIST_MOVIES("List Movies", new ListCommand(ItemType.MOVIE), OptionVisibility.ALWAYS) {
    },

    LOGIN("Login", new LoginCommand(), OptionVisibility.NOT_LOGGED_IN) {
    },

    DISPLAY_DETAILS("My Details", new DisplayDetailsCommand(), OptionVisibility.LOGGED_IN) {
    };

    public String getValue() {
        return displayName;
    }

    public void perform(Library library, StdOut stdOut, StdIn stdIn) {
        command.perform(library, stdOut, stdIn);
    }

    private final String displayName;
    protected Command command;

    MenuItem(String displayName, Command command, OptionVisibility always) {
        this.displayName = displayName;
        this.command = command;
    }
}
