package biblioteca.models;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
    @DisplayName("expect Game Of Thrones when printing GameOfThrones book")
    @Test
    void shouldReturnGameOfThronesString() {
        Book gameOfThrones = new Book("Game Of Thrones");
        assertEquals("Game Of Thrones", gameOfThrones.getTitle());
    }
}