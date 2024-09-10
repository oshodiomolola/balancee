package com.balancee.reward_demo.controller;

import com.balancee.reward_demo.model.CashbackHistory;
import com.balancee.reward_demo.model.Customer;
import com.balancee.reward_demo.service.CashbackHistoryService;
import com.balancee.reward_demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CashbackHistoryService cashbackHistoryService;

    @GetMapping("/{customerId}/balance")
    public ResponseEntity<Double> getCurrentBalance(@PathVariable Long customerId) {
        if (customerId == null || customerId <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        double currentBalance = customerService.calculateCurrentBalance(customerId);
        if (currentBalance >= 0) {
            return ResponseEntity.ok(currentBalance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{customerId}/history")
    public ResponseEntity<List<CashbackHistory>> getCashbackHistory(@PathVariable Long customerId) {
        List<CashbackHistory> history = cashbackHistoryService.getHistoryByCustomerId(customerId);
        if (history.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(history);
    }
}
