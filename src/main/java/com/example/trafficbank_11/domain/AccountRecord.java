package com.example.trafficbank_11.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AccountRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long fromId;
    @Column
    private Long toId;
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


}
