package com.bookstack.bookstack.modules.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstack.bookstack.modules.authentication.dtos.AuthenticationDTO;
import com.bookstack.bookstack.modules.authentication.dtos.AuthenticationResponseDTO;
import com.bookstack.bookstack.modules.security.TokenService;
import com.bookstack.bookstack.modules.users.entities.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private TokenService tokenService;

  @PostMapping
  public ResponseEntity auth(@RequestBody @Valid AuthenticationDTO data) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
    var auth = this.authenticationManager.authenticate(usernamePassword);

    var token = this.tokenService.generateToken((User) auth.getPrincipal());

    return ResponseEntity.ok(new AuthenticationResponseDTO(token));
  }
}
