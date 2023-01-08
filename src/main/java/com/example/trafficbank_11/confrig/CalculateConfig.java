package com.example.trafficbank_11.confrig;


import com.example.trafficbank_11.domain.Account;
import com.example.trafficbank_11.domain.AccountRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

//@Configuration
//@RequiredArgsConstructor
//public class CalculateConfig {
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//    private final EntityManagerFactory entityManagerFactory;
//    private static final int chunkSize = 20;
//
//    @Bean
//    public Job job(){
//        return jobBuilderFactory.get("calculateJob")
//                .start(step())
//                .build();
//    }
//
//    @Bean
//    @JobScope
//    public Step step(){
//        return stepBuilderFactory.get("calculateStep")
//                .<AccountRecord, Account>chunk(chunkSize)
//                .reader(reader(null))
//                .processor(processor(null))
//                .writer(writer(null))
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public JpaCursorItemReader<AccountRecord> reader(@Value("#{jobParameters[requestDate]}")String requestDate){
//        System.out.println("reader, requestDate: "+requestDate);
//        Map<String, Object> parameters = new HashMap<>();
//        return new JpaCursorItemReaderBuilder<AccountRecord>()
//                .name("jpaCursorItemReader")
//                .entityManagerFactory(entityManagerFactory)
//                .queryString("SELECT a FROM AccountRecord a")
//                .build();
//    }
//
//    @Bean
//    public ItemProcessor<AccountRecord, Account> processor(){
//        return Account.builder()
//                .id()
//                .build();
//    }
//
//    @Bean
//    public ItemWriter<Account> writer(){
//        return list -> {
//            for(Account account : list){
//                System.out.println(account);
//            }
//        }
//    }
//}
