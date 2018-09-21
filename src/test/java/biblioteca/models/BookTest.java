package biblioteca.models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
    private Book gameOfThrones;
    @BeforeEach
    void init() {
        this.gameOfThrones = new Book("Game Of Thrones", "George Martin", 1996);
    }

    @DisplayName("expect to return all the details when getDetails of GameOfThrones book is called")
    @Test
    void shouldReturnGameOfThronesString() {
        String expected = "Game Of Thrones,George Martin,1996";
        assertEquals(expected, gameOfThrones.getDetails());
    }
}