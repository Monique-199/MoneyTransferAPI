package com.kpezesha.MoneyTransfer.controller;

import com.kpezesha.MoneyTransfer.model.TransferRequest;
import com.kpezesha.MoneyTransfer.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * REST Controller for handling money transfer operations.
 * Maps HTTP requests related to transfers to the appropriate service layer methods.
 */
@RestController
@RequestMapping("/transfers")
public class TransferController {

    /**
     * Service layer responsible for executing the money transfer logic.
     */
    private final TransferService transferService;

    /**
     * Constructor-based dependency injection for TransferService.
     *
     * @param transferService the service layer to handle transfer operations
     */
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    /**
     * Endpoint to transfer money from one account to another.
     * Validates the incoming request and delegates the transfer operation to the service layer.
     *
     * @param transferRequest the details of the transfer, including source account ID,
     *                        target account ID, and transfer amount.
     * @return a response indicating the success of the transfer operation.
     */
    @PostMapping
    public ResponseEntity<String> transferMoney(@Valid @RequestBody TransferRequest transferRequest) {
        // Perform the transfer operation
        transferService.transferMoney(transferRequest);
        // Return a success message as the response
        return ResponseEntity.ok("Transfer successful");
    }
}
