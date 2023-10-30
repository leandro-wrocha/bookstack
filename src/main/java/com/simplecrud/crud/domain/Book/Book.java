package com.simplecrud.crud.domain.Book;

import java.util.Date;

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
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  private Date created_at;

  private Date updated_at;

  public Book(Integer id) {
    this.id = id;
  }
}
