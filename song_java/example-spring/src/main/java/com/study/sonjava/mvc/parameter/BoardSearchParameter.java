package com.study.sonjava.mvc.parameter;

import lombok.Data;

/**
 * 게시글 검색 파라미터
 */
@Data
public class BoardSearchParameter {

    private String keyword;

    public BoardSearchParameter(){}   // 기본생성자
    
}
