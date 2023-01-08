package com.example.trafficbank_11.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long money;

    @Column
    private LocalDateTime createdDate;
    @Column
    private LocalDateTime modifiedDate;

    @PrePersist
    public void prePersist(){
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.modifiedDate = LocalDateTime.now();
    }

    public void plusMoney(Long money){
        this.money += money;
    }

    public void minusMoney(Long money){
        this.money -= money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
