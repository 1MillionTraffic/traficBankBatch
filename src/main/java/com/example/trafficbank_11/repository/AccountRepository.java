package com.example.trafficbank_11.repository;

import com.example.trafficbank_11.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
