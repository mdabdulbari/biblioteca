package biblioteca.controller;

import biblioteca.view.StdOut;

public class InitializeApplication {
    private StdOut stdOut;
    private MainMenu mainMenu;

    public InitializeApplication(StdOut stdOut, MainMenu mainMenu) {
        this.stdOut = stdOut;
        this.mainMenu = mainMenu;
    }

    public void run() {
        stdOut.print("Welcome to biblioteca");
        mainMenu.displayOptionsAndAskForOption();
    }
}
