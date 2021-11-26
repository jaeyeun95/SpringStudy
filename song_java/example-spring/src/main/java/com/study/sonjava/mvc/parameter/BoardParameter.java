package com.study.sonjava.mvc.parameter;

import lombok.Data;

@Data
public class BoardParameter {

    private int boardSeq;
    private String title;
    private String contents;
    private String boardType; 
    private boolean delYn;

    public BoardParameter(){}   // 기본생성자

    public BoardParameter(String title, String contents){   // 테스트용 생성자
        this.title = title;
        this.contents = contents;
    }
    public BoardParameter(String title, String contents, String boardType){   // 테스트용 생성자
        this.title = title;
        this.contents = contents;
        this.boardType = boardType;
    }
    
}
