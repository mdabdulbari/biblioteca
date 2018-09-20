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

    @DisplayName("expect Game Of Thrones when printing GameOfThrones book")
    @Test
    void shouldReturnGameOfThronesString() {
        assertEquals("Game Of Thrones", gameOfThrones.getTitle());
    }

    @DisplayName("should return George Martin when printing author of Game Of Thrones book")
    @Test
    void shouldReturnNameOfTheAuthor() {
        assertEquals("George Martin", gameOfThrones.getAuthor());
    }

    @DisplayName("should return 1996 when getting year published of Game Of Thrones book")
    @Test
    void shouldReturnYearPublished() {
        assertEquals(1996, gameOfThrones.getYearPublished());
    }
}