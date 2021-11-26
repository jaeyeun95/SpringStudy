package com.study.sonjava.scheduler;

import java.util.Calendar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ExampleScheduler {

    // @Scheduled(cron = "*/5 * * * * *")
    @Scheduled(cron = "#{@schedulerCronExample1}")
    public void schedule1(){
        log.info("schedule1 동작하고 있음 : {} ", Calendar.getInstance().getTime());
    }
    
}
