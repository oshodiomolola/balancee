package com.balancee.reward_demo.service;

import com.balancee.reward_demo.model.Customer;
import com.balancee.reward_demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CashbackHistoryService cashbackHistoryService;

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    public double calculateCurrentBalance(Long customerId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            double totalCashback = customer.getTotalCashback();
            double usedCashBack = cashbackHistoryService.getUsedCashback(customerId); // Ensure this method exists and works as expected
            return totalCashback - usedCashBack;
        }
        return 0.0;
    }
}
