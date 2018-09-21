package biblioteca.controller;

import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

public class InitializeApplication {
    private StdOut stdOut;
    private MainMenu mainMenu;
    private StdIn stdIn;

    public InitializeApplication(StdOut stdOut, MainMenu mainMenu, StdIn stdIn) {
        this.stdOut = stdOut;
        this.mainMenu = mainMenu;
        this.stdIn = stdIn;
    }

    public void run() {
        stdOut.print("Welcome to biblioteca");
        mainMenu.displayOptionsAndAskForOption();
    }
}
