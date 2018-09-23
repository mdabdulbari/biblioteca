package biblioteca.controller;

import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class MainMenu {
    private StdOut stdOut;
    private Library library;
    private StdIn stdIn;
    private List<MenuItem> menuItems;

    public MainMenu(StdOut stdOut, Library library, StdIn stdIn) {
        this.stdOut = stdOut;
        this.library = library;
        this.stdIn = stdIn;
        menuItems = new ArrayList<>();
        menuItems.add(MenuItem.LIST_BOOKS);
        menuItems.add(MenuItem.LIST_MOVIES);
        menuItems.add(MenuItem.CHECKOUT_BOOK);
        menuItems.add(MenuItem.RETURN);
        menuItems.add(MenuItem.LOGIN);
        menuItems.add(MenuItem.QUIT);
    }

    public void displayOptionsAndAskForOption() {
        int optionSelected;
        do {
            optionSelected = displayOptionsAndTakeOptionFromTheUser();
            if (!isValid(optionSelected)) {
                stdOut.print("Please select a valid option!");
            } else {
                menuItems.get(optionSelected - 1).perform(library, stdOut, stdIn);
            }
        } while (optionSelected != 5);
    }

    private int displayOptionsAndTakeOptionFromTheUser() {
        AtomicInteger serialNumber = new AtomicInteger(1);
        AtomicReference<String> options = new AtomicReference<>("");
        menuItems.forEach(menuItem -> {
            options.set(options + "" + serialNumber + ") " + menuItem.getValue() + "     ");
            serialNumber.addAndGet(1);
        });
        stdOut.print(options.toString());
        stdOut.print("Please select an option: ");
        return stdIn.takeInteger();
    }

    private boolean isValid(int optionSelected) {
        if (optionSelected == 0 || optionSelected > menuItems.size()) {
            return false;
        }
        return true;
    }
}
