package biblioteca.models;

public class Movie implements LibraryItem {
    private String name;
    private int year;
    private String director;
    private double rating;
    private ItemType type;

    public Movie(String name, int year, String director, double rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        type = ItemType.MOVIE;
    }

    public String getDetails() {
        return name + "," + year + "," + director + "," + rating;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public ItemType getType() {
        return type;
    }
}
