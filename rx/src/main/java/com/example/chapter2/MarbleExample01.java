package com.example.chapter2;

import io.reactivex.Observable;

public class MarbleExample01 {
    public static void main(String[] args) {
        Observable.just(1, 25, 9, 15, 7, 30)    //  데이터 발행
            .filter(x -> x >10) // 데이터 가공
            .subscribe(x -> System.out.println(x)); // 데이터 구독
    }
    
}
