package com.example.chapter1;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class ToDoSample {
    public static void main(String[] args) throws InterruptedException {
        Observable.just(100, 200, 300, 400, 500)
            .doOnNext(data -> System.out.println(getThreadName() + " : " + "#doOnNext() : " + data))
            // .subscribe(Scheduler.io())
            // .observeOn(Schedulers.computation())
            .filter(number -> number > 300)
            .subscribe(num -> System.out.println(getThreadName() + " : result : " + num));

            // Thread.sleep(500);
    }

    public static String getThreadName() {
        return Thread.currentThread().getName();
    }
    
}
