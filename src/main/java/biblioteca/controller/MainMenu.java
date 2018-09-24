package biblioteca.controller;

import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        menuItems.add(MenuItem.QUIT);
        menuItems.add(MenuItem.LOGIN);
        menuItems.add(MenuItem.LIST_BOOKS);
        menuItems.add(MenuItem.LIST_MOVIES);
        menuItems.add(MenuItem.CHECKOUT_BOOK);
        menuItems.add(MenuItem.RETURN);
        menuItems.add(MenuItem.DISPLAY_DETAILS);
    }

    public void displayOptionsAndAskForOption() {
        int optionSelected;
        int index = 0;
        do {
            optionSelected = displayOptionsAndTakeOptionFromTheUser();
            if (!isValid(optionSelected)) {
                stdOut.print("Please select a valid option!");
            } else {
                if(library.loggedIn()){
                    if(optionSelected == 0) {
                        return;
                    }
                    index = optionSelected + 1;
                }
                else {
                    index = optionSelected;
                }
                menuItems.get(index).perform(library, stdOut, stdIn);
            }
        } while (doesNotWantToQuit(optionSelected));
    }

    private boolean doesNotWantToQuit(int optionSelected) {
        return optionSelected != 0;
    }

    private int displayOptionsAndTakeOptionFromTheUser() {
        String options = (library.loggedIn())?generateOptionsForUserLoggedIn()
                :generateOptionsForUserNotLoggedIn();
        stdOut.print(options);
        stdOut.print("Please select an option: ");
        return stdIn.takeInteger();
    }

    private String generateOptionsForUserLoggedIn() {
        String options = "";
        int serialNumber = 0;
        List<MenuItem> loggedInUserMenuItems = generateListForUserLoggedIn();
        for (MenuItem menuItem : loggedInUserMenuItems) {
            options += "" + serialNumber + ") " + menuItem.getValue() + "     ";
            serialNumber += 1;
        }
        return options;
    }

    private List<MenuItem> generateListForUserLoggedIn() {
        return menuItems.stream()
                .filter(menuItem ->
                        menuItem.getStatus() == OptionVisibility.ALWAYS
                                || menuItem.getStatus() == OptionVisibility.LOGGED_IN)
                .collect(Collectors.toList());
    }

    private String generateOptionsForUserNotLoggedIn() {
        String options = "";
        int serialNumber = 0;
        List<MenuItem> menuItemsForUserNotLoggedIn = generateListForUserNotLoggedIn();
        for (MenuItem menuItem : menuItemsForUserNotLoggedIn) {
            options += "" + serialNumber + ") " + menuItem.getValue() + "     ";
            serialNumber += 1;
        }
        return options;
    }

    private List<MenuItem> generateListForUserNotLoggedIn() {
        return menuItems.stream().filter(
                menuItem -> menuItem.getStatus() == OptionVisibility.ALWAYS
                        || menuItem.getStatus() == OptionVisibility.NOT_LOGGED_IN)
                .collect(Collectors.toList());
    }

    private boolean isValid(int optionSelected) {
        if(library.loggedIn()){
            if (optionSelected > 5) {
                return false;
            }
            return true;
        }
        if (optionSelected > 3) {
            return false;
        }
        return true;
    }
}
