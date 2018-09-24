package biblioteca.controller.commands;

import biblioteca.models.ItemType;
import biblioteca.models.Library;
import biblioteca.view.StdIn;
import biblioteca.view.StdOut;

public class ListCommand implements Command {
    private ItemType itemType;

    public ListCommand(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public void perform(Library library, StdOut stdOut, StdIn stdIn) {
        if (itemType == ItemType.BOOK) {
            headingForPrintingBooks(stdOut);
        } else {
            headingForPrintingMovies(stdOut);
        }
        library.getList(itemType).forEach((bookDetails) ->
                stdOut.print(formatPrintingOfBook(bookDetails)));
    }

    private String formatPrintingOfBook(String string) {
        String[] splitString = string.split(",");
        String formattedString = "";
        formattedString = String.format("%-60s", splitString[0]);
        for (int i = 1; i < splitString.length; i += 1) {
            formattedString += String.format("%-30s", splitString[i]);
        }
        return formattedString;
    }

    private void headingForPrintingBooks(StdOut stdOut) {
        stdOut.print("------------------------Here is the list of all the books in the library----------------------");
        stdOut.print("==============================================================================================");
        stdOut.print("Book                                                        Author              Year Published");
        stdOut.print("==============================================================================================");
    }

    private void headingForPrintingMovies(StdOut stdOut) {
        stdOut.print("--------------------------------------------Here are all the movies in the library--------------------------------------------");
        stdOut.print("==============================================================================================================================");
        stdOut.print("Movie                                                       Year Released                 Director                      Rating");
        stdOut.print("==============================================================================================================================");
    }
}
