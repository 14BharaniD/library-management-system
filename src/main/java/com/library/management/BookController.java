package com.library.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // 1. Changed from @RestController
import org.springframework.ui.Model; // 2. We need this to pass data to the HTML
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody; // 3. We need this for our API
import java.util.List;

@Controller // 4. This is the main change!
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // 5. This method serves our HTML page
    @GetMapping("/") // This will handle requests to the homepage
    public String showHomePage(Model model) {
        // Get all books from the database
        List<Book> books = bookRepository.findAll();
        
        // Add the list of books to the "model" so the HTML page can access it
        model.addAttribute("books", books);
        
        // Return the name of the HTML file (index.html)
        return "index";
    }

    // --- API Endpoints ---
    // These methods will still work just like before, but we add @ResponseBody

    @GetMapping("/api/books")
    @ResponseBody // 6. Tells Spring to return JSON, not an HTML page
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/api/books")
    @ResponseBody // 7. Tells Spring to return JSON
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
}