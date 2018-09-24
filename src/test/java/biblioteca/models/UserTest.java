package biblioteca.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class UserTest {
    private User user;
    private UserInformation userInformation;

    @BeforeEach
    void init() {
        userInformation = mock(UserInformation.class);
        user = new User("123-4567", "password", userInformation);
    }

    @DisplayName("should return true for correct details")
    @Test
    void shouldReturnTrueForCorrectDetails() {
        assertTrue(user.authenticate("123-4567", "password"));
    }

    @DisplayName("should return false for incorrect details")
    @Test
    void shouldReturnFalseForIncorrectDetails() {
        assertFalse(user.authenticate("123-4567", "wrongPassword"));
    }

    @DisplayName("should call getDetails of userInformation when getInformation is called")
    @Test
    void shouldReturnUserInformation() {
        user.getInformation();
        verify(userInformation).getDetails();
    }
}
