package biblioteca.controller;

import biblioteca.models.Library;
import biblioteca.view.StdOut;

public enum MenuItem {
    LIST_BOOKS("List books") {
        @Override
        void act(Library library, StdOut stdOut) {
            stdOut.print("---Here are all the books in the library---");
            library.getBookDetails().forEach(stdOut::print);
        }

        @Override
        public String getValue() {
            return "List books";
        }
    },

    QUIT("Quit") {
        @Override
        void act(Library library,  StdOut stdOut) {
            System.exit(0);
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
