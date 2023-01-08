package com.example.trafficbank_11.service;

import com.example.trafficbank_11.domain.Account;
import com.example.trafficbank_11.domain.AccountRecord;
import com.example.trafficbank_11.repository.AccountRecordRepository;
import com.example.trafficbank_11.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

@Service
public class AccountBatchService {
    private final AccountRepository accountRepository;
    private final AccountRecordRepository accountRecordRepository;

    public AccountBatchService(AccountRepository accountRepository, AccountRecordRepository accountRecordRepository) {
        this.accountRepository = accountRepository;
        this.accountRecordRepository = accountRecordRepository;
    }

    @Transactional
    public void calculate(){
        LocalDateTime start = LocalDateTime.now().minusMinutes(20L);
        LocalDateTime end = LocalDateTime.now().plusMinutes(20L);
        System.out.println("start: "+start);
        System.out.println("end: "+end);
        List<AccountRecord> accountRecords = accountRecordRepository.findAllByCreatedDateBetween(start, end);
        System.out.println("accountRecords length: "+accountRecords.size());
        for(AccountRecord accountRecord : accountRecords){
            Account fromUser = accountRepository.findById(accountRecord.getFromId())
                    .orElseThrow(() -> new IllegalArgumentException(""));
            Account toUser = accountRepository.findById(accountRecord.getToId())
                    .orElseThrow(() -> new IllegalArgumentException(""));
            fromUser.minusMoney(accountRecord.getMoney());
            toUser.plusMoney(accountRecord.getMoney());
            accountRepository.save(fromUser);
            accountRepository.save(toUser);
        }
    }
}
