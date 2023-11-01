package com.simplecrud.crud.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplecrud.crud.domain.Book.Book;
import com.simplecrud.crud.domain.Book.BookRepository;
import com.simplecrud.crud.domain.Book.StoreBookDTO;
import com.simplecrud.crud.domain.Book.UpdateBookDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookRepository bookRepository;

  @GetMapping
  public ResponseEntity index() {
    var allBooks = bookRepository.findAll();

    return ResponseEntity.ok(allBooks);
  }

  @PostMapping
  public ResponseEntity store(@RequestBody @Valid StoreBookDTO data) {
    Book storeBook = new Book(data);
    bookRepository.save(storeBook);

    return ResponseEntity.status(201).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@RequestBody @Valid UpdateBookDTO data, @PathVariable String id) {
    Optional<Book> bookExists = bookRepository.findById(id);

    if (bookExists.isPresent()) {
      try {
        Book bookToUpdate = bookExists.get();
        bookToUpdate.setName(data.name());
        bookRepository.save(bookToUpdate);
        return ResponseEntity.ok(bookToUpdate);
      } catch (Error exception) {
        System.out.println(exception);
        return ResponseEntity.internalServerError().build();
      }
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity destroy(@PathVariable String id) {
    Optional<Book> bookExists = bookRepository.findById(id);

    if (bookExists.isPresent()) {
      try {
        Book bookToDelete = bookExists.get();
        bookRepository.deleteById(bookToDelete.getId());

        return ResponseEntity.noContent().build();
      } catch (Error exception) {
        System.out.println(exception);
        return ResponseEntity.internalServerError().build();
      }
    }

    return ResponseEntity.notFound().build();
  }
}
