package biblioteca.common;

import biblioteca.models.*;

import java.util.ArrayList;
import java.util.List;


public class Helpers {
    public Library createLibraryWithBooks() {
        List<LibraryItem> libraryItems = new ArrayList<>();

        Book iHate = new Book("I Hate", "Abdul", 2018);
        Book thiss = new Book("Thiss", "Bari", 2018);
        Book assignment = new Book("Assignment", "Mohammad", 2018);

        Movie shawshank = new Movie("The Shawshank Redemption", 1994, "Frank Darabont", 9.3);
        Movie incredibles = new Movie("The Incredibles", 1994, "Frank Darabont", 9.3);

        libraryItems.add(iHate);
        libraryItems.add(thiss);
        libraryItems.add(assignment);
        libraryItems.add(shawshank);
        libraryItems.add(incredibles);

        return new Library(libraryItems, users());
    }

    private List<User> users() {
        List<User> users = new ArrayList<>();
        User user1 = new User("111-1111", "asdfasdf");
        User user2 = new User("222-2222", "asdfasdfasdf");
        users.add(user1);
        users.add(user2);
        return users;
    }
}
