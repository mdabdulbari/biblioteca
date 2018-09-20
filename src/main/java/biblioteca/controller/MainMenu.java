package biblioteca.controller;

import biblioteca.Helpers;
import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<String> options;
    private StdOut stdOut;
    private StdIn stdIn;


    MainMenu(StdOut stdOut, StdIn stdIn) {
        this.stdOut = stdOut;
        this.stdIn = stdIn;
        this.options = new ArrayList<>();
        options.add("1. List of Books");
    }

    public void displayOptionsAndAskForOption() {
        options.forEach(option -> stdOut.print(option));
        stdOut.print("Please select an option: ");
        int optionSelected = stdIn.takeInteger();
        if (optionSelected == 1) {
            displayBooks();
            return;
        }
        stdOut.print("Select a valid option!");
    }

    private void displayBooks() {
        stdOut.print("---Here are all the books in the library---");
        stdOut.print("Book      Author      Year Published");
        stdOut.print("------------------------------------");
        Helpers helpers = new Helpers();
        Library library = helpers.createLibraryWithBooks();
        List<String> bookTitles = library.getBookDetails();
        bookTitles.forEach(book -> stdOut.print(book));
    }
}










