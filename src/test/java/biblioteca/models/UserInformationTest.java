package biblioteca.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInformationTest {
    @DisplayName("should return list of all the details of user")
    @Test
    void shouldReturnUserDeatils() {
        UserInformation userInformation = new UserInformation("asdf", "asdf@gmail.com", 1234123412);
        List<String> expectedList = new ArrayList<>();
        expectedList.add("asdf");
        expectedList.add("asdf@gmail.com");
        expectedList.add("1234123412");

        assertEquals(expectedList, userInformation.getDetails());
    }
}
