package biblioteca.controller;

import biblioteca.models.Library;
import biblioteca.view.StdOut;

public enum MenuItem {
    LIST_BOOKS("List books") {
        @Override
        void act(Library library, StdOut stdOut) {
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
            splitString[0] = String.format("%-60s",splitString[0]);
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
        void act(Library library, StdOut stdOut) {
        }

        @Override
        public String getValue() {
            return "Quit";
        }
    };

    public String getValue() {
        return null;
    }

    abstract void act(Library library, StdOut stdOut);

    private final String displayName;

    MenuItem(String displayName) {
        this.displayName = displayName;
    }
}
