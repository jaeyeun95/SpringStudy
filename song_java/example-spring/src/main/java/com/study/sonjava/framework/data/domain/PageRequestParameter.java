package com.study.sonjava.framework.data.domain;

import lombok.Data;

/**
 * 페이지 요청정보와 파라미터 정보
 */
@Data
public class PageRequestParameter<T> {

    private MySQLPageRequest pageRequest;
    private T parameter;    // 원하는 타입으로 받아서 사용할 수 있게 하기위해 제너릭으로 받음

    public PageRequestParameter(MySQLPageRequest pageRequest, T parameter){
        this.pageRequest = pageRequest;
        this.parameter = parameter;
    }
    
}
