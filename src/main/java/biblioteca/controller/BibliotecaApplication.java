package biblioteca.controller;

import biblioteca.view.StdOut;

public class BibliotecaApplication {
    public static void main(String[] args) {
        StdOut stdOut = new StdOut();
        MainMenu mainMenu = new MainMenu(stdOut);
        InitializeApplication initializeApplication = new InitializeApplication(stdOut, mainMenu);
        initializeApplication.run();
    }
}
