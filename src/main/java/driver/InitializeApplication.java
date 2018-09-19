package driver;

import LibraryManagementSystem.Biblioteca;
import view.StdOut;

class InitializeApplication {
    private StdOut stdOut;

    InitializeApplication(StdOut stdOut) {
        this.stdOut = stdOut;
    }

    void run() {
        stdOut.print("Welcome to Biblioteca");
        Biblioteca biblioteca = new Biblioteca(stdOut);
    }
}
