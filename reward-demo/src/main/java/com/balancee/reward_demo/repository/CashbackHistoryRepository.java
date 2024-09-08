package com.balancee.reward_demo.repository;

import com.balancee.reward_demo.model.CashbackHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashbackHistoryRepository extends JpaRepository<CashbackHistory, Long> {
    List<CashbackHistory> findByCustomerId(Long customerId);
}
