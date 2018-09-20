package biblioteca.driver;

import biblioteca.view.StdOut;

class InitializeApplication {
    private StdOut stdOut;

    InitializeApplication(StdOut stdOut) {
        this.stdOut = stdOut;
    }

    void run() {
        stdOut.print("Welcome to biblioteca");
//        biblioteca biblioteca = new biblioteca(stdOut);
//        biblioteca.printBooks();
    }
}
