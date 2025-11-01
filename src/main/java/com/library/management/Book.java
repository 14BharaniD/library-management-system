package com.library.management;

// Import the tools we need from jakarta.persistence
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // 1. Tells Spring this class is a database table.
public class Book {

    @Id // 2. Marks this field as the Primary Key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3. Auto-increments the ID.
    private Long id; // We use Long for database IDs.
    
    private String title;
    private String author;
    private String isbn;
    private boolean isIssued;

    // --- Constructors ---
    // A default, no-argument constructor is required by JPA.
    public Book() {
    }

    // A constructor for creating new books (the ID is auto-generated).
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isIssued = false; // New books are always available.
    }

    // --- Getters and Setters ---
    // JPA also needs getters and setters to access the fields.
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        this.isIssued = issued;
    }
}