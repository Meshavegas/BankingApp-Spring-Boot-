package com.vegas.dev.Banking.Repository;

import com.vegas.dev.Banking.entity.AccountingJournal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJournalRepository extends JpaRepository<AccountingJournal, Integer> {
}
