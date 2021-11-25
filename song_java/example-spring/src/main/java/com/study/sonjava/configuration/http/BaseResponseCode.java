package com.study.sonjava.configuration.http;

public enum BaseResponseCode {

    // SUCCESS(200), // 성공
    // ERROR(500), // 실패
    SUCCESS, // 성공
    ERROR, // 실패
    LOGIN_REQUIRED,
    DATA_IS_NULL,   // Null
    VALIDATE_REQUIRED,  // 필수체크
    ;

    private int status;

    // BaseResponseCode(int status){
    //     this.status = status;
    // }

    public int status(){
        return status;
    }
 

}
