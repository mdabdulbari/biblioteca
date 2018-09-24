package biblioteca;

import biblioteca.common.Helpers;
import biblioteca.controller.InitializeApplication;
import biblioteca.controller.MainMenu;
import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

public class BibliotecaApplication {
    public static void main(String[] args) {
        StdOut stdOut = new StdOut();
        StdIn stdIn = new StdIn();

        Helpers helpers = new Helpers();
        Library library = helpers.createLibrary();
        MainMenu mainMenu = new MainMenu(stdOut, library, stdIn);

        InitializeApplication initializeApplication = new InitializeApplication(stdOut, mainMenu);
        initializeApplication.run();
    }
}
