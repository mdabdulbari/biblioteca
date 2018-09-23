package biblioteca.models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {
    private Movie movie;

    @BeforeEach
    void init() {
        movie = new Movie("The Shawshank Redemption", 1994, "Frank Darabont", 9.3);
    }

    @DisplayName("should return movie details as a string")
    @Test
    void shouldReturnMovieDetails() {
        String expected = "The Shawshank Redemption,1994,Frank Darabont,9.3";
        assertEquals(expected, movie.getDetails());
    }

    @DisplayName("should return The Shawshank Redemption")
    @Test
    void shouldReturnName() {
        assertEquals("The Shawshank Redemption", movie.getTitle());
    }

    @DisplayName("should return ItemType as Movie")
    @Test
    void shouldReturnItemTypeMovie() {
        assertEquals(ItemType.MOVIE, movie.getType());
    }
}