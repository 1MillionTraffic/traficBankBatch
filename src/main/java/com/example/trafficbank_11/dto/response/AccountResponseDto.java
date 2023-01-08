package com.example.trafficbank_11.dto.response;


import com.example.trafficbank_11.domain.Account;
import lombok.Getter;

@Getter
public class AccountResponseDto {
    private final Long id;
    private final Long money;

    private AccountResponseDto(Account account){
        this.id = account.getId();
        this.money = account.getMoney();
    }

    public static AccountResponseDto of(Account account){
        return new AccountResponseDto(account);
    }
}
