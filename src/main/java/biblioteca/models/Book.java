package biblioteca.models;

public class Book implements LibraryItem {
    private String title;
    private String author;
    private int yearPublished;
    private ItemType type;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        type = ItemType.BOOK;
    }

    public String getDetails() {
        return title + "," + author + "," + yearPublished;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public ItemType getType() {
        return type;
    }
}
