package biblioteca.models;

class Movie {

    private String name;
    private int year;
    private String director;
    private double rating;

    Movie(String name, int year, String director, double rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }


    String getDetails() {
        return name + "," + year + "," + director + "," + rating;
    }
}
