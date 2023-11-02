package com.bookstack.bookstack.modules.book.entities;

import java.util.Date;

import com.bookstack.bookstack.modules.book.dtos.StoreBookDTO;
import com.bookstack.bookstack.modules.book.dtos.UpdateBookDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "books")
@Entity(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String name;

  private Date created_at;

  private Date updated_at;

  public Book(String id) {
    this.id = id;
  }

  public Book(StoreBookDTO storeBookDTO) {
    this.name = storeBookDTO.name();
    this.created_at = new Date();
    this.updated_at = new Date();
  }

  public Book(UpdateBookDTO updateBookDTO) {
    this.name = updateBookDTO.name();
    this.updated_at = new Date();
  }
}
