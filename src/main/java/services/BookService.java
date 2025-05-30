package services;

import models.Book;

public class BookService {
    private Book currentBook = new Book("Приклад книги", "Автор", 2023);

    public Book getBook() {
        return currentBook;
    }

    public void saveBook(Book book) {
        this.currentBook = book;
    }
}
