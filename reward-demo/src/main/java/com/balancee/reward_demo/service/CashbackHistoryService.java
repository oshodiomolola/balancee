package com.balancee.reward_demo.service;

import com.balancee.reward_demo.model.CashbackHistory;
import com.balancee.reward_demo.repository.CashbackHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashbackHistoryService {
    @Autowired
    private CashbackHistoryRepository cashbackHistoryRepository;

    public List<CashbackHistory> getHistoryByCustomerId(Long customerId) {
        return cashbackHistoryRepository.findByCustomerId(customerId);
    }
}
