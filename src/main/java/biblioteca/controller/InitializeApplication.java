package biblioteca.controller;

import biblioteca.Helpers;
import biblioteca.models.Library;
import biblioteca.view.StdOut;

public class InitializeApplication {
    private StdOut stdOut;

    public InitializeApplication(StdOut stdOut) {
        this.stdOut = stdOut;
    }

    public void run() {
        stdOut.print("Welcome to biblioteca");
        Helpers helpers = new Helpers();
        Library library = helpers.createLibraryWithBooks();
        stdOut.print(library.toString());
    }
}
