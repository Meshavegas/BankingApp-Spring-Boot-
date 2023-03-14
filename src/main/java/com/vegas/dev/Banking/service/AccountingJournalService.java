package com.vegas.dev.Banking.service;

import com.vegas.dev.Banking.Repository.AccountJournalRepository;
import com.vegas.dev.Banking.auth.JournalRequest;
import com.vegas.dev.Banking.entity.AccountingJournal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountingJournalService {
    AccountJournalRepository accountJournalRepository;
    public List<AccountingJournal> getJournal() {

        return accountJournalRepository.findAll();
    }

    public  void createLog(JournalRequest journalRequest){
        var journal = AccountingJournal.builder();
    }
}
