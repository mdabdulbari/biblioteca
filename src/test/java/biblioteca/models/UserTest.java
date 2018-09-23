package biblioteca.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {
    @DisplayName("should return true for correct details")
    @Test
    void shouldReturnTrueForCorrectDetails() {
        User user = new User("123-4567", "password");
        assertTrue(user.authenticate("123-4567", "password"));
    }

    @DisplayName("should return false for incorrect details")
    @Test
    void shouldReturnFalseForIncorrectDetails() {
        User user = new User("123-4567", "password");
        assertFalse(user.authenticate("123-4567", "wrongPassword"));
    }
}
