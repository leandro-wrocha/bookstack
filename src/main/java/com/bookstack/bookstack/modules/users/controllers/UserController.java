package com.bookstack.bookstack.modules.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstack.bookstack.modules.users.dtos.StoreUserDTO;
import com.bookstack.bookstack.modules.users.entities.User;
import com.bookstack.bookstack.modules.users.repositories.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping
  public ResponseEntity<String> store(@RequestBody @Valid StoreUserDTO data) {
    try {

      User userCreated = new User(data);
      userCreated.setPassword(new BCryptPasswordEncoder().encode(data.password()));
      userRepository.save(userCreated);

      return ResponseEntity.status(201).build();
    } catch (Error exception) {
      System.out.println("Error (UserController::store): " + exception);

      return ResponseEntity.internalServerError().build();
    }
  }
}
