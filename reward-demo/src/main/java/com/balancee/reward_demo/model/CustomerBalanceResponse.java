package com.balancee.reward_demo.model;

public class CustomerBalanceResponse {
    private Long customerId;
    private Double totalCashback;
    private Double currentBalance;

    public CustomerBalanceResponse(Long customerId, Double totalCashback, Double currentBalance) {
        this.customerId = customerId;
        this.totalCashback = totalCashback;
        this.currentBalance = currentBalance;
    }
}
