package com.library.management;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Tells Spring this is a Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // That's it!
    
    // Spring Data JPA will automatically create methods like:
    // 1. save(Book book)
    // 2. findById(Long id)
    // 3. findAll()
    // 4. delete(Book book)
    // ...and many more, just from this one line!
}