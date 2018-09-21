package biblioteca.controller;

import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class MainMenu {
    private StdOut stdOut;
    private Library library;
    private StdIn stdIn;
    private List<MenuItem> menuItems;


    MainMenu(StdOut stdOut, Library library, StdIn stdIn) {
        this.stdOut = stdOut;
        this.library = library;
        this.stdIn = stdIn;
        menuItems = new ArrayList<>();
        menuItems.add(MenuItem.LIST_BOOKS);
        menuItems.add(MenuItem.QUIT);
    }

    public void displayOptionsAndAskForOption() {
        AtomicInteger serialNumber = new AtomicInteger(1);
        menuItems.forEach(menuItem -> {
                    stdOut.print(serialNumber + ") " + menuItem.getValue());
                    serialNumber.addAndGet(1);
                });
        stdOut.print("Please select an option: ");
        int optionSelected = stdIn.takeInteger();
        if(optionSelected == 0 || optionSelected > menuItems.size()) {
            stdOut.print("Please select a valid option!");
            return;
        }
        menuItems.get(optionSelected - 1).act(library, stdOut);
    }
}










