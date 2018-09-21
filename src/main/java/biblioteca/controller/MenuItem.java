package biblioteca.controller;

import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

public enum MenuItem {
    LIST_BOOKS("List books") {
        @Override
        void act(Library library, StdOut stdOut, StdIn stdIn) {
            stdOut.print("---Here are all the books in the library---");
            stdOut.print("==============================================================================================");
            stdOut.print("Book                                                        Author              Year Published");
            stdOut.print("==============================================================================================");
            library.getBookDetails().forEach((bookDetails) ->
                    stdOut.print(formatPrintingOfBook(bookDetails)));
            stdOut.print("==============================================================================================");
        }

        private String formatPrintingOfBook(String string) {
            String[] splitString = string.split(",");
            splitString[0] = String.format("%-60s", splitString[0]);
            splitString[1] = String.format("%-20s", splitString[1]);
            splitString[2] = String.format("%-4s", splitString[2]);
            return splitString[0] + splitString[1] + splitString[2];
        }

        @Override
        public String getValue() {
            return "List books";
        }
    },

    QUIT("Quit") {
        @Override
        void act(Library library, StdOut stdOut, StdIn stdIn) {
        }

        @Override
        public String getValue() {
            return "Quit";
        }
    }, CHECKOUT("Checkout") {
        @Override
        void act(Library library, StdOut stdOut, StdIn stdIn) {
            MenuItem.LIST_BOOKS.act(library, stdOut, stdIn);
            stdOut.print("Please enter the book you want: ");
            String bookSelected = stdIn.takeString();
            if(!library.checkout(bookSelected)) {
                stdOut.print("That book is not available.");
            }
            else stdOut.print("Thank you! Enjoy the book");
        }

        @Override
        public String getValue() {
            return "Checkout";
        }
    }, RETURN("Return") {
        @Override
        void act(Library library, StdOut stdOut, StdIn stdIn) {
            stdOut.print("Please enter the book you want to return: ");
            String bookReturning = stdIn.takeString();
            if(!library.returnBook(bookReturning)) {
                stdOut.print("That is not a valid book to return.");
            }
            else stdOut.print("Thank you for returning the book.");
        }

        @Override
        public String getValue() {
            return "Return";
        }
    };

    public String getValue() {
        return null;
    }

    abstract void act(Library library, StdOut stdOut, StdIn stdIn);

    private final String displayName;

    MenuItem(String displayName) {
        this.displayName = displayName;
    }
}
