package com.example.trafficbank_11.service;

import com.example.trafficbank_11.domain.Account;
import com.example.trafficbank_11.domain.AccountRecord;
import com.example.trafficbank_11.repository.AccountRecordRepository;
import com.example.trafficbank_11.repository.AccountRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

//@Commit
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class AccountBatchServiceTotalTest {
    @Autowired
    private AccountBatchService accountBatchService;
    @Autowired
    private AccountRecordRepository accountRecordRepository;
    @Autowired
    private AccountRepository accountRepository;

    private Long fromId;
    private Long toId;

    @BeforeAll
    public void setUp() {
        Account fromAccount = Account.builder()
                .money(100_000L)
                .build();
        Account toAccount = Account.builder()
                .money(100_000L)
                .build();
        fromId = accountRepository.save(fromAccount).getId();
        toId = accountRepository.save(toAccount).getId();
        for(int i = 0; i < 100; i++){
            AccountRecord accountRecord = AccountRecord.builder()
                    .fromId(fromId)
                    .toId(toId)
                    .money(10L)
                    .build();
            accountRecordRepository.save(accountRecord);
        }
    }

    @Test
    public void test() {
        accountBatchService.calculate();
        Account findFromAccount = accountRepository.findById(fromId)
                .orElseThrow(() ->  new IllegalArgumentException(""));
        Account findToAccount = accountRepository.findById(toId)
                .orElseThrow(() -> new IllegalArgumentException(""));
        System.out.println("from: "+findFromAccount);
        System.out.println("to: "+findToAccount);
    }
}
