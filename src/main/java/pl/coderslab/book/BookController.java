package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.services.BookService;
import pl.coderslab.services.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @RequestMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L,
                "9788324631766",
                "Thinking in Java",
                "Bruce Eckel",
                "Helion",
                "programming");
    }

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/")
    public List<Book> getAll() {
        return bookService.getList();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/")
    public Book postById(@RequestBody Book book) {
        bookService.addBook(book);
        return book;
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id,@RequestBody Book book) {
        bookService.updateBook(id, book);
        return book;
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        bookService.deleteBookById(id);
        return "OK";
    }

}

