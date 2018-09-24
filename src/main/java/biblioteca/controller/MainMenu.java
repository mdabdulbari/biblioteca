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
    private List<MenuItem> menuItemsForLoggedInUser;
    private List<MenuItem> menuItemsForUserNotLoggedIn;

    public MainMenu(StdOut stdOut, Library library, StdIn stdIn) {
        this.stdOut = stdOut;
        this.library = library;
        this.stdIn = stdIn;
        menuItemsForLoggedInUser = new ArrayList<>();
        menuItemsForUserNotLoggedIn = new ArrayList<>();
        menuItemsForLoggedInUser.add(MenuItem.LIST_BOOKS);
        menuItemsForLoggedInUser.add(MenuItem.LIST_MOVIES);
        menuItemsForLoggedInUser.add(MenuItem.CHECKOUT_BOOK);
        menuItemsForLoggedInUser.add(MenuItem.RETURN);
        menuItemsForLoggedInUser.add(MenuItem.DISPLAY_DETAILS);
        menuItemsForLoggedInUser.add(MenuItem.QUIT);
        menuItemsForUserNotLoggedIn.add(MenuItem.LOGIN);
        menuItemsForUserNotLoggedIn.add(MenuItem.LIST_BOOKS);
        menuItemsForUserNotLoggedIn.add(MenuItem.LIST_MOVIES);
        menuItemsForUserNotLoggedIn.add(MenuItem.QUIT);
    }

    public void displayOptionsAndAskForOption() {
        int optionSelected;
        do {
            optionSelected = displayOptionsAndTakeOptionFromTheUser();
            if (!isValid(optionSelected)) {
                stdOut.print("Please select a valid option!");
            } else {
                if(library.loggedIn()){
                    menuItemsForLoggedInUser.get(optionSelected - 1).perform(library, stdOut, stdIn);
                }
                else {
                    menuItemsForUserNotLoggedIn.get(optionSelected - 1).perform(library, stdOut, stdIn);
                }
            }
        } while (doesNotWantToQuit(optionSelected));
    }

    private boolean doesNotWantToQuit(int optionSelected) {
        return optionSelected != 6 && !(optionSelected == 4 && !library.loggedIn());
    }

    private int displayOptionsAndTakeOptionFromTheUser() {
        int serialNumber = 1;
        String options = "";
        if(library.loggedIn()) {
            for (MenuItem menuItem : menuItemsForLoggedInUser) {
                options += "" + serialNumber + ") " + menuItem.getValue() + "     ";
                serialNumber += 1;
            }
        }
        else {
            for (MenuItem menuItem : menuItemsForUserNotLoggedIn) {
                options += "" + serialNumber + ") " + menuItem.getValue() + "     ";
                serialNumber += 1;
            }
        }
        stdOut.print(options);
        stdOut.print("Please select an option: ");
        return stdIn.takeInteger();
    }

    private boolean isValid(int optionSelected) {
        if(library.loggedIn()){
            if (optionSelected == 0 || optionSelected > menuItemsForLoggedInUser.size()) {
                return false;
            }
        }
        if (optionSelected == 0 || optionSelected > menuItemsForUserNotLoggedIn.size()) {
            return false;
        }
        return true;
    }
}
