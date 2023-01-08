package com.example.trafficbank_11.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountRecordSaveRequestDto {
    private Long fromId;
    private Long toId;
    private Long money;
}
