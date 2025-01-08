package com.kpezesha.MoneyTransfer.service;

import com.kpezesha.MoneyTransfer.model.Account;
import com.kpezesha.MoneyTransfer.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
 * Service class responsible for managing account-related operations.
 */
@Service
public class AccountService {

    // Repository for performing CRUD operations on Account entities
    private final AccountRepository accountRepository;

    /**
     * Constructor to inject the AccountRepository dependency.
     *
     * @param accountRepository the repository for account operations
     */
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Creates a new account with the specified initial balance.
     *
     * @param initialBalance the starting balance for the account
     * @return the newly created account
     */
    public Account createAccount(Double initialBalance) {
        // Create a new Account instance and set its initial balance
        Account account = new Account();
        account.setBalance(initialBalance);

        // Save the account to the repository and return it
        return accountRepository.save(account);
    }

    /**
     * Retrieves an account by its unique identifier (ID).
     *
     * @param id the ID of the account to retrieve
     * @return an Optional containing the account if found, or empty if not found
     */
    public Optional<Account> getAccountById(Long id) {
        // Retrieve the account from the repository by its ID
        return accountRepository.findById(id);
    }
}
