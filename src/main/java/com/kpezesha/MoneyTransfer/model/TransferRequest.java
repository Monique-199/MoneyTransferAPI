package com.kpezesha.MoneyTransfer.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Model class representing the request for transferring money between accounts.
 * Includes validation annotations to enforce constraints on input data.
 */
public class TransferRequest {

    /**
     * ID of the source account from which money will be transferred.
     * Must not be null.
     */
    @NotNull
    private Long sourceAccountId;

    /**
     * ID of the target account to which money will be transferred.
     * Must not be null.
     */
    @NotNull
    private Long targetAccountId;

    /**
     * Amount of money to be transferred.
     * Must be greater than or equal to 1.
     */
    @Min(1)
    private double amount;

    /**
     * Gets the ID of the source account.
     *
     * @return the ID of the source account
     */
    public @NotNull Long getSourceAccountId() {
        return sourceAccountId;
    }

    /**
     * Sets the ID of the source account.
     *
     * @param sourceAccountId the ID of the source account
     */
    public void setSourceAccountId(@NotNull Long sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    /**
     * Gets the ID of the target account.
     *
     * @return the ID of the target account
     */
    @NotNull
    public Long getTargetAccountId() {
        return targetAccountId;
    }

    /**
     * Sets the ID of the target account.
     *
     * @param targetAccountId the ID of the target account
     */
    public void setTargetAccountId(@NotNull Long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    /**
     * Gets the amount to be transferred.
     *
     * @return the transfer amount
     */
    @Min(1)
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount to be transferred.
     *
     * @param amount the transfer amount
     */
    public void setAmount(@Min(1) double amount) {
        this.amount = amount;
    }
}
