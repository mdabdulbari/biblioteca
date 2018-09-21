package biblioteca.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StdInTest {
    @DisplayName("expect takeInteger function to not return 2 when 3 is given as input")
    @Test
    void shouldNotReturn2() {
        setSystemIn("3\n");
        StdIn stdIn = new StdIn();
        assertNotEquals(2, stdIn.takeInteger());
    }

    @DisplayName("expect takeInteger function to return 2 when it is called")
    @Test
    void shouldReturn2() {
        setSystemIn("2\n");
        StdIn stdIn = new StdIn();
        assertEquals(2, stdIn.takeInteger());
    }

    private void setSystemIn(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    @AfterEach
    void setup() {
        System.setIn(System.in);
    }
}
