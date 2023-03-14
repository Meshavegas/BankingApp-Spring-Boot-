package com.vegas.dev.Banking.controller;

import com.vegas.dev.Banking.auth.AccountRequest;
import com.vegas.dev.Banking.auth.ResponseRequest;
import com.vegas.dev.Banking.entity.Account;
import com.vegas.dev.Banking.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    @GetMapping
    public List<Account> getAccount(){
        return ResponseEntity.ok(
                accountService.getAccounts()
        ).getBody();
    }
    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody AccountRequest request, Principal principal){
        return ResponseEntity.ok(
          accountService.createAccount(request,principal)
        );
    }
    @PostMapping("/crediter/{accountId}")
    public ResponseEntity<ResponseRequest> credit(@PathVariable ("accountId")Integer accountId, @RequestParam("ammount") double ammount,Principal principal){
        System.out.println("Montant ->"+ammount);

        return ResponseEntity.ok(
                accountService.crediter(accountId,ammount,principal)
        );
    }

    @PostMapping("/debit/{accountId}")
    public ResponseEntity<ResponseRequest> debit(@PathVariable ("accountId")Integer accountId, @RequestParam("ammount") double ammount,Principal principal){
        System.out.println("Montant ->"+ammount);

        return ResponseEntity.ok(
                accountService.debiter(accountId,ammount,principal)
        );
    }

}
