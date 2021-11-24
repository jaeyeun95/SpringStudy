package com.study.sonjava.mvc.domain;

/** 
 *  게시판 종류
 */
public enum BoardType implements BaseCodeLabelEnum {
    
    NOTICE("공지사항"),
    FAQ("자주묻는질문"),
    INQUIRY("1:1 문의"),
    ;
    
    private String code;
    private String label;

    BoardType(String label){
        this.code = name(); // name은 enum 에서 제공제공되는 메소드
        this.label = label;
    }

    public String code(){
        return code;
    }

    public String label(){
        return label;
    }

}
