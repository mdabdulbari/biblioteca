package biblioteca.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String libraryNumber;
    private final String password;
    private UserInformation userInformation;
    private List<LibraryItem> checkOutItems;

    public User(String libraryNumber, String password, UserInformation userInformation) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.userInformation = userInformation;
        checkOutItems = new ArrayList<>();
    }

    boolean authenticate(String libraryNumber, String password) {
        return libraryNumber.equals(this.libraryNumber) && password.equals(this.password);
    }


    public List<String> getInformation() {
        return userInformation.getDetails();
    }

    public boolean hasItem(LibraryItem libraryItem) {
        return checkOutItems.contains(libraryItem);
    }

    public void checkoutItem(LibraryItem libraryItem) {
        checkOutItems.add(libraryItem);
    }

    public void returnItem(LibraryItem libraryItem) {
        checkOutItems.remove(libraryItem);
    }
}
