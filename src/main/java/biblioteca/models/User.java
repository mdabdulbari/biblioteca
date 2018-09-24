package biblioteca.models;

import java.util.List;

public class User {
    private final String libraryNumber;
    private final String password;
    private UserInformation userInformation;

    public User(String libraryNumber, String password, UserInformation userInformation) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.userInformation = userInformation;
    }

    boolean authenticate(String libraryNumber, String password) {
        return libraryNumber.equals(this.libraryNumber) && password.equals(this.password);
    }


    public List<String> getInformation() {
        return userInformation.getDetails();
    }
}
