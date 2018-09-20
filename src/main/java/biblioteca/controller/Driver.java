package biblioteca.controller;

import biblioteca.view.StdOut;

public class Driver {
    public static void main(String[] args) {
        StdOut stdOut = new StdOut();
        InitializeApplication initializeApplication = new InitializeApplication(stdOut);
        initializeApplication.run();
    }
}
