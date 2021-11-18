package com.study.springboot.service;

import com.study.springboot.dao.Transaction1Dao;
import com.study.springboot.dao.Transaction2Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BuyTicketService implements IBuyTicketService{

    @Autowired
    Transaction1Dao transaction1;
    @Autowired
    Transaction2Dao transaction2;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Override
    public int buy(String consumerId, int amount, String error) {

        try {
            // doInTrasactionWithoutResult 메소드 안에 작성한 비즈니스 로직에서 에러가 발생하지 않는다면
            // 정상적으로 커밋 처리가 되고, 에러가 발생하면 롤백 처리가 된다.
            // 트랜잭션 범위의 비즈니스 로직을 감싸서 볼 수 있고, 커밋, 롤백이 자동으로 처리된다는 점이 트랜잭션 매니저와 비교했을 떄 장점
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
               @Override
               protected void doInTransactionWithoutResult(TransactionStatus arg0){

                   transaction1.pay(consumerId, amount);

                   // 의도적 에러 발생
                   if(error.equals("1")){ int n = 10/0 ;}
       
                   transaction2.pay(consumerId, amount);
               } 
            });
            return 1;
        } catch (Exception e) {
            System.out.println("[PlatformTransactionManager] Rollback");
            return 0;
        }
    }
    
}
