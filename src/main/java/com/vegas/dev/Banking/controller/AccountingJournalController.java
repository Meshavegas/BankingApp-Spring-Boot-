package com.vegas.dev.Banking.controller;

import com.vegas.dev.Banking.entity.AccountingJournal;
import com.vegas.dev.Banking.service.AccountingJournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/journal")
@RequiredArgsConstructor
public class AccountingJournalController {
    AccountingJournalService accountingJournalService;
    @GetMapping
    public ResponseEntity<List<AccountingJournal>> getJournals(){
        return ResponseEntity.ok(
                accountingJournalService.getJournal()
        );
    }
}
