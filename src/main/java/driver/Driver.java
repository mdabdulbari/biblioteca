package driver;

import view.StdOut;

public class Driver {
    public static void main(String[] args) {
        StdOut stdOut = new StdOut();
        InitializeApplication initializeApplication = new InitializeApplication(stdOut);
        initializeApplication.run();
    }
}
