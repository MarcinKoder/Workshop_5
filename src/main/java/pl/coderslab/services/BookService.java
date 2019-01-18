package pl.coderslab.services;

import pl.coderslab.book.Book;

import java.util.List;

public interface BookService {
    List<Book> getList();

    Book getBookById(Long id);

    void addBook(Book book);

    void updateBook(Long id, Book newBook);

    void deleteBookById(Long id);
}
