package com.kpezesha.MoneyTransfer.controller;

import com.kpezesha.MoneyTransfer.model.Account;
import com.kpezesha.MoneyTransfer.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * REST Controller for managing account-related operations.
 * Handles HTTP requests for creating accounts and retrieving account information.
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

    /**
     * Service layer responsible for business logic related to accounts.
     */
    private final AccountService accountService;

    /**
     * Constructor-based dependency injection for AccountService.
     *
     * @param accountService the service layer to handle account operations
     */
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Endpoint to create a new account with an initial balance.
     *
     * @param initialBalance the starting balance for the new account (must be non-negative).
     * @return the created account, including its ID and initial balance.
     */
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestParam Double initialBalance) {
        // Create a new account using the service layer
        Account account = accountService.createAccount(initialBalance);
        // Return the created account as a response
        return ResponseEntity.ok(account);
    }

    /**
     * Endpoint to retrieve account details by account ID.
     *
     * @param id the unique identifier of the account to be retrieved.
     * @return the account details if found, or a 404 Not Found response if the account does not exist.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        // Fetch account details from the service layer
        Optional<Account> account = accountService.getAccountById(id);
        // Return the account details if found, otherwise return a 404 response
        return account.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
