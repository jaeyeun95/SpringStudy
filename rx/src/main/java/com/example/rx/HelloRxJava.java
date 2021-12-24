package com.example.rx;

import org.springframework.core.OverridingClassLoader;

import io.reactivex.Observable;

public class HelloRxJava {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Hello", "RxJava");
        observable.subscribe(data -> System.out.println(data));
    }
    
}
