package com.study.sonjava.framework.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * MySQL 페이지 요청 정보 및 계산된 값
 */
@Data
public class MySQLPageRequest {
    
    private int page;
    private int size;

    @JsonIgnore
    private int limit;

    @JsonIgnore
    private int offset;

    public MySQLPageRequest(int page, int size, int limit, int offset){
        this.page = page;
        this.size = size;
        this.limit = limit;
        this.offset = offset;
    }
}
