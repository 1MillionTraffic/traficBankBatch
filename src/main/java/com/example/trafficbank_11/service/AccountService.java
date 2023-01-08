package com.example.trafficbank_11.service;


import com.example.trafficbank_11.domain.Account;
import com.example.trafficbank_11.dto.response.AccountResponseDto;
import com.example.trafficbank_11.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    @Transactional
    public AccountResponseDto findAccountById(Long accountId){
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException(""));
        return AccountResponseDto.of(account);
    }


}
