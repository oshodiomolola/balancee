package com.balancee.reward_demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_cashback", nullable = false)
    private double totalCashback;

    @Column(name = "current_balance", nullable = false)
    private double currentBalance;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CashbackHistory> cashbackHistories;

    public Customer() {
    }

    public Customer(double totalCashback, double currentBalance) {
        this.totalCashback = totalCashback;
        this.currentBalance = currentBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalCashback() {
        return totalCashback;
    }

    public void setTotalCashback(double totalCashback) {
        this.totalCashback = totalCashback;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<CashbackHistory> getCashbackHistories() {
        return cashbackHistories;
    }

    public void setCashbackHistories(List<CashbackHistory> cashbackHistories) {
        this.cashbackHistories = cashbackHistories;
    }
}

