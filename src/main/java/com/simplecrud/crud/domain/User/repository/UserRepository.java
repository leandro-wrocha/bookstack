package com.simplecrud.crud.domain.User.repository;

import com.simplecrud.crud.domain.User.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
