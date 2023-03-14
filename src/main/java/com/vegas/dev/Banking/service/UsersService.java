package com.vegas.dev.Banking.service;

import com.vegas.dev.Banking.Repository.UsersRepository;
import com.vegas.dev.Banking.auth.AuthentificationRequest;
import com.vegas.dev.Banking.auth.AuthentificationResponse;
import com.vegas.dev.Banking.auth.RegisterRequest;
import com.vegas.dev.Banking.config.JwtService;
import com.vegas.dev.Banking.entity.Role;
import com.vegas.dev.Banking.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager manager;
    public AuthentificationResponse login(AuthentificationRequest request) {



        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();


        var jwtToken = jwtService.genereToken(user);

        return AuthentificationResponse.builder().token(jwtToken).build();
    }

    public AuthentificationResponse regiter(RegisterRequest request) {
        Optional<Users> user = repository.findByEmail(request.getEmail());
        if (user.isPresent()){
            return AuthentificationResponse.builder().token("Utilisateur deja inscript").build();
        }
        var users = Users.builder()
                .name(request.getName())
                .createdBy(request.getName())
                .updatedBy(request.getName())
                .updateAt(new Timestamp(System.currentTimeMillis()))
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();

        repository.save(users);
        var jwtToken = jwtService.genereToken(users);

        return AuthentificationResponse.builder().token(jwtToken).build();
    }

    public Optional<Users> getUser(String username) {

    return repository.findByEmail(username);
    }
}
