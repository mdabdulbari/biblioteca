package biblioteca.controller;

import biblioteca.Helpers;
import biblioteca.models.Library;
import biblioteca.view.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private List<String> options;
    private StdOut stdOut;
    private Scanner scanner;

    MainMenu(StdOut stdOut) {
        this.stdOut = stdOut;
        this.options = new ArrayList<>();
        options.add("1. List of Books");
        scanner = new Scanner(System.in);
    }

    public void displayOptionsAndAskForOption() {
        options.forEach(option -> stdOut.print(option));
        stdOut.print("Please select an option: ");
        int optionSelected = scanner.nextInt();
        if(optionSelected == 1) {
            displayBooks();
        }
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
