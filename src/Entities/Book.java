package Entities;

import java.util.ArrayList;

public class Book {
    private final String bookTitle;
    private final String authorName;
    private static final ArrayList<Book> books = new ArrayList<>();

    Book(String bookTitle, String authorName) {
        this.bookTitle = bookTitle;
        this.authorName = authorName;
    }

    public String getTitle() { return this.bookTitle; }
    public String getAuthorName() { return this.authorName; }
    public static void insertBook(String title, String author) {
        books.add(new Book(title, author));
    }
    public static ArrayList<Book> getAllBooks() {
        return books;
    }
}
