package com.simplecrud.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplecrud.crud.domain.Book.BookRepository;

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
}
