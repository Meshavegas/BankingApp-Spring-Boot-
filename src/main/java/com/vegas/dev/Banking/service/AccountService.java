package com.vegas.dev.Banking.service;

import com.vegas.dev.Banking.Repository.AccountJournalRepository;
import com.vegas.dev.Banking.Repository.AccountRepository;
import com.vegas.dev.Banking.Repository.UsersRepository;
import com.vegas.dev.Banking.auth.AccountRequest;
import com.vegas.dev.Banking.auth.ResponseRequest;
import com.vegas.dev.Banking.entity.Account;
import com.vegas.dev.Banking.entity.AccountingJournal;
import com.vegas.dev.Banking.entity.Direction;
import com.vegas.dev.Banking.entity.Users;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final UsersRepository usersRepository;
    private final AccountJournalRepository accountJournalRepository;
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public String createAccount(AccountRequest request, Principal principal) {
        Optional<Users> users = usersRepository.findByEmail(principal.getName());

        var account = Account.builder()
                .accountNumber("Compte_"+request.idUser+"_"+ (int)(Math.floor(Math.random()*2560)))
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .createdBy(principal.getName())
                .updatedBy(principal.getName())
                .users(users.get())
                .currency(request.currency)
                .balance(0.0)
                .build();
        accountRepository.save(account);
        return "sucess";
    }

    @Transactional
    public ResponseRequest crediter(Integer accountId, double ammount, Principal principal) {
        System.out.println("user ->"+principal.getName());
        Optional<Account> account = accountRepository.findById(accountId);
        Optional<Users> users = usersRepository.findByEmail(principal.getName());
        var journal = AccountingJournal.builder()
                .account(account.get())
                .amount(ammount).direction(Direction.CREDIT.name())
                .lastBalance(account.get().getBalance())
                .newBalance(account.get().getBalance()+ammount)
                        .createBy(users.get().getName())
                                .creaedAt(new Timestamp(System.currentTimeMillis())).build();

        accountJournalRepository.save(journal);
        account.get().setBalance(account.get().getBalance()+ammount);
        account.get().setUpdatedBy(users.get().getName());
        account.get().setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        accountRepository.save(account.get());


        return ResponseRequest.builder().reponse("Crediter avec sucess").build();
    }

    @Transactional
    public ResponseRequest debiter(Integer accountId, double ammount, Principal principal) {
        System.out.println("user ->"+principal.getName());
        Optional<Account> account = accountRepository.findById(accountId);
        Optional<Users> users = usersRepository.findByEmail(principal.getName());
        var journal = AccountingJournal.builder()
                .account(account.get())
                .amount(ammount).direction(Direction.DEBIT.name())
                .lastBalance(account.get().getBalance())
                .newBalance(account.get().getBalance()-ammount)
                .createBy(users.get().getName())
                .creaedAt(new Timestamp(System.currentTimeMillis())).build();

        accountJournalRepository.save(journal);
        account.get().setBalance(account.get().getBalance()-ammount);
        account.get().setUpdatedBy(users.get().getName());
        account.get().setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        accountRepository.save(account.get());


        return ResponseRequest.builder().reponse("Crediter avec sucess").build();
    }
}
