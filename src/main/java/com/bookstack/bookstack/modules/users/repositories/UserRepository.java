package com.bookstack.bookstack.modules.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.bookstack.bookstack.modules.users.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
  UserDetails findByEmail(String email);
}
