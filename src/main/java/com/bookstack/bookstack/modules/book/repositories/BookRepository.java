package com.bookstack.bookstack.modules.book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstack.bookstack.modules.book.entities.Book;

public interface BookRepository extends JpaRepository<Book, String> {
}
