package biblioteca.models;

import biblioteca.view.StdOut;

import java.util.List;

public class Biblioteca {

    List<Book> books;

    public Biblioteca(StdOut stdOut) {
        Book got = new Book("Game of Thrones");
        Book harryPotter = new Book("Haryy Potter");
        Book headFirstJava = new Book("Head First Java");
        books.add(got);
        books.add(harryPotter);
        books.add(headFirstJava);
    }

    @Override
    public String toString() {
        return books.toString();
    }
}
