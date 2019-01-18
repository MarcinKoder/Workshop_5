package pl.coderslab.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.coderslab.book.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService implements BookService {
    private List<Book> list;
    public static Long PUBLIC_ID = 0L;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(newId(),
                "9788324631766",
                "Thinking in Java",
                "Bruce Eckel",
                "Helion",
                "programming"));
        list.add(new Book(newId(),
                "9788324627738",
                "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert",
                "Helion",
                "programming"));
        list.add(new Book(newId(),
                "9780130819338",
                "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell",
                "Helion",
                "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public Book getBookById(Long id) {
        for (Book book : list) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public Long newId() {
        return PUBLIC_ID++;
    }

    public void addBook(Book book) {
        book.setId(newId());
        list.add(book);
    }

    public void updateBook(Long id, Book newBook) {
        if (id == newBook.getId()) {
            for (Book book : list) {
                if (book.getId() == id) {
                    book.setPublisher(newBook.getPublisher());
                    book.setTitle(newBook.getTitle());
                    book.setIsbn(newBook.getIsbn());
                    book.setType(newBook.getType());
                    book.setAuthor(newBook.getAuthor());
                }
            }
        }
    }


    public void deleteBookById(Long id) {
        Book bookToDelete = getBookById(id);
        if (bookToDelete != null) {
            list.remove(bookToDelete);
        }
    }
}