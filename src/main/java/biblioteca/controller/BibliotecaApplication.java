package biblioteca.controller;

import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

public class BibliotecaApplication {
    public static void main(String[] args) {
        StdOut stdOut = new StdOut();
        StdIn stdIn = new StdIn();
        MainMenu mainMenu = new MainMenu(stdOut, stdIn);
        InitializeApplication initializeApplication = new InitializeApplication(stdOut, mainMenu, stdIn);
        initializeApplication.run();
    }
}
