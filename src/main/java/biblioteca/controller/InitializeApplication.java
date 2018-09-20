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
        printBookTitles();

    }

    private void printBookTitles() {
        Helpers helpers = new Helpers();
        Library library = helpers.createLibraryWithBooks();
        List<String> bookTitles = library.getTitles();
        bookTitles.forEach(book -> stdOut.print(book));
    }
}
