package com.example.trafficbank_11.service;

import com.example.trafficbank_11.domain.Account;
import com.example.trafficbank_11.domain.AccountRecord;
import com.example.trafficbank_11.repository.AccountRecordRepository;
import com.example.trafficbank_11.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start =  LocalDateTime.of(now.getYear(), now.getMonth().getValue(), now.getDayOfMonth(), 0, 0, 0, 0);
        LocalDateTime end = start.plusDays(1L).minusNanos(1);
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
            // entity manager 쓰기 지연을 이용 위해 save 불 필요
//            accountRepository.save(fromUser);
//            accountRepository.save(toUser);
        }
    }
}
