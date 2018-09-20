package biblioteca.models;

public class Book {
    private String title;
    private String author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    int getYearPublished() {
        return yearPublished;
    }
}
