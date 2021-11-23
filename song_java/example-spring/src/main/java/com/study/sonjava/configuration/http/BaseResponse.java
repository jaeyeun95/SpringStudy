package com.study.sonjava.configuration.http;

import lombok.Data;
/**
 *  공통으로 사용할 응답 클래스.
 *  @author 재윤
 *  @param <T>
 */

@Data
public class BaseResponse<T> {

    private BaseResponseCode code;
    private String message;
    private T data;

    // 성공일 떄 
    public BaseResponse(T data){
        this.code = BaseResponseCode.SUCCESS;
        this.data = data;
    }

    // 예외나 에러가 발생했을 때 
    public BaseResponse(BaseResponseCode code, String message) {
        this.code = code;
        this.message = message;
    }

    
}
