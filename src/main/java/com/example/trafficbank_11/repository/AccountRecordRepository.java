package com.example.trafficbank_11.repository;

import com.example.trafficbank_11.domain.AccountRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AccountRecordRepository extends JpaRepository<AccountRecord, Long> {
    List<AccountRecord> findAllByCreatedDateBetween(LocalDateTime start, LocalDateTime end);
}
