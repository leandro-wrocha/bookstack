package com.simplecrud.crud.domain.User.model;

import java.util.Date;

import com.simplecrud.crud.domain.User.dtos.StoreUserDTO;
// import com.simplecrud.crud.domain.User.enums.Role;

import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String email;

  private String password;

  // @Enumerated(EnumType.STRING)
  // private Role role;

  private Date created_at;

  private Date updated_at;

  public User(Long id) {
    this.id = id;
  }

  public User(StoreUserDTO storeUserDTO) {
    this.name = storeUserDTO.name();
    this.email = storeUserDTO.email();
    this.password = storeUserDTO.password();
    // this.role = storeUserDTO.role();
    this.created_at = new Date();
    this.updated_at = new Date();
  }
}
