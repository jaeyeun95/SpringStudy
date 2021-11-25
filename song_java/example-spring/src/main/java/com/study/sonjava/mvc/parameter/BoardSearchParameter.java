package com.study.sonjava.mvc.parameter;

import java.util.List;

import com.study.sonjava.mvc.domain.BoardType;

import lombok.Data;

/**
 * 게시글 검색 파라미터
 */
@Data
public class BoardSearchParameter {

    private String keyword;
    private List<BoardType> boardTypes;

    public BoardSearchParameter(){}   // 기본생성자
    
}
