package com.balancee.reward_demo.controller;

import com.balancee.reward_demo.model.CashbackHistory;
import com.balancee.reward_demo.model.Customer;
import com.balancee.reward_demo.model.CustomerBalanceResponse;
import com.balancee.reward_demo.service.CashbackHistoryService;
import com.balancee.reward_demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    @Autowired
    private CashbackHistoryService cashbackHistoryService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/history/{customerId}")
    public ResponseEntity<List<CashbackHistory>> getCashbackHistory(@PathVariable Long customerId) {
        List<CashbackHistory> history = cashbackHistoryService.getHistoryByCustomerId(customerId);
        if (history != null && !history.isEmpty()) {
            return ResponseEntity.ok(history);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(history);
        }
    }

    @PostMapping("/history")
    public ResponseEntity<CashbackHistory> addCashbackTransaction(@RequestBody CashbackHistory cashbackHistory) {
        CashbackHistory newTransaction = cashbackHistoryService.addCashbackTransaction(cashbackHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTransaction);
    }

    @GetMapping("/balance/{customerId}")
    public ResponseEntity<CustomerBalanceResponse> getRewardsBalance(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            double currentBalance = customerService.calculateCurrentBalance(customerId);
            CustomerBalanceResponse response = new CustomerBalanceResponse(customer.getId(), customer.getTotalCashback(), currentBalance);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
