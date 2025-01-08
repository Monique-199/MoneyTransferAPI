package com.kpezesha.MoneyTransfer.service;

import com.kpezesha.MoneyTransfer.model.Account;
import com.kpezesha.MoneyTransfer.model.TransferRequest;
import com.kpezesha.MoneyTransfer.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class responsible for handling money transfer operations between accounts.
 */
@Service
public class TransferService {

    // Repository to access and manage account data
    private final AccountRepository accountRepository;

    /**
     * Constructor to inject the AccountRepository dependency.
     *
     * @param accountRepository the repository for account operations
     */
    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Transfers money from the source account to the target account.
     * Ensures all necessary constraints are validated.
     *
     * @param transferRequest the details of the transfer operation
     * @throws IllegalArgumentException if any validation constraints fail
     */
    @Transactional
    public void transferMoney(TransferRequest transferRequest) {
        // Retrieve source account; throw an exception if not found
        Account source = accountRepository.findById(transferRequest.getSourceAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Source account not found"));

        // Retrieve target account; throw an exception if not found
        Account target = accountRepository.findById(transferRequest.getTargetAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Target account not found"));

        // Validate that the transfer amount is greater than zero
        if (transferRequest.getAmount() <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than zero");
        }

        // Ensure the source account has sufficient balance for the transfer
        if (source.getBalance() < transferRequest.getAmount()) {
            throw new IllegalArgumentException("Insufficient balance in source account");
        }

        // Deduct the transfer amount from the source account
        source.setBalance(source.getBalance() - transferRequest.getAmount());

        // Add the transfer amount to the target account
        target.setBalance(target.getBalance() + transferRequest.getAmount());

        // Save the updated account states to the repository
        accountRepository.save(source);
        accountRepository.save(target);
    }
}
