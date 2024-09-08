package com.balancee.reward_demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cashback_history")
public class CashbackHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate;

    @Column(name = "amount_earned", nullable = false)
    private double amountEarned;

    @Column(name = "description", length = 255)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public CashbackHistory() {
    }

    public CashbackHistory(LocalDate transactionDate, double amountEarned, String description, Customer customer) {
        this.transactionDate = transactionDate;
        this.amountEarned = amountEarned;
        this.description = description;
        this.customer = customer;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmountEarned() {
        return amountEarned;
    }

    public void setAmountEarned(double amountEarned) {
        this.amountEarned = amountEarned;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

