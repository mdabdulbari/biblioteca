package biblioteca.controller;

import biblioteca.Helpers;
import biblioteca.models.Library;
import biblioteca.view.StdOut;

import java.util.List;

public class InitializeApplication {
    private StdOut stdOut;

    public InitializeApplication(StdOut stdOut) {
        this.stdOut = stdOut;
    }

    public void run() {
        stdOut.print("Welcome to biblioteca");
        displayBooks();

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
