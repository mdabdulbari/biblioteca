package biblioteca.models;

import java.util.ArrayList;
import java.util.List;

public class UserInformation {
    private final String name;
    private final String email;
    private final long phoneNumber;

    public UserInformation(String name, String email, long phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public List<String> getDetails() {
        List<String> userDetails = new ArrayList<>();
        userDetails.add(name);
        userDetails.add(email);
        userDetails.add(Long.toString(phoneNumber));
        return userDetails;
    }
}
