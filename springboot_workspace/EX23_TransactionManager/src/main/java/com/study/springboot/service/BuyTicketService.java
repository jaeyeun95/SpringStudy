package com.study.springboot.service;

import com.study.springboot.dao.Transaction1Dao;
import com.study.springboot.dao.Transaction2Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BuyTicketService implements IBuyTicketService{

    @Autowired
    Transaction1Dao transaction1;
    @Autowired
    Transaction2Dao transaction2;

    @Autowired
    PlatformTransactionManager transactionManager;  // 트랜잭션 매니저 변수 선언
    @Autowired
    TransactionDefinition definition;       // 트랜잭션 매니저에서 사용할 설정을 만드는데 설정값은 기본으로 제공되는 값을 그대로 사용

    @Override
    public int buy(String consumerId, int amount, String error) {

        TransactionStatus status = transactionManager.getTransaction(definition);

        log.debug("#### Transaction status :: " + status);
        System.out.println("#### Transaction status :: " + status);

        try {
            transaction1.pay(consumerId, amount);

            // 의도적 에러 발생
            if(error.equals("1")){ int n = 10/0 ;}

            transaction2.pay(consumerId, amount);

            transactionManager.commit(status);
            return 1;
        } catch (Exception e) {
            System.out.println("[PlatformTransactionManager] Rollback");
            transactionManager.rollback(status);    // 이전 설정부터 현재 라인까지 데이터베이스 처리결과에 대해서 롤백
            return 0;
        }
    }
    
}
