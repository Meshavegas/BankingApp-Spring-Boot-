package com.vegas.dev.Banking.controller;

import com.vegas.dev.Banking.auth.AuthentificationRequest;
import com.vegas.dev.Banking.auth.AuthentificationResponse;
import com.vegas.dev.Banking.auth.RegisterRequest;
import com.vegas.dev.Banking.entity.Users;
import com.vegas.dev.Banking.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService service;
    @PostMapping("/signup")
    public ResponseEntity<AuthentificationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return  ResponseEntity.ok(
                service.regiter(request)
        );
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthentificationResponse> login(
            @RequestBody AuthentificationRequest request
    ){
        return  ResponseEntity.ok(
                service.login(request)
        );
    }

    @GetMapping("/user")
    public ResponseEntity<Optional<Users>> getUser(Principal user){
        return ResponseEntity.ok(
                service.getUser(user.getName())
        );
    }
}
