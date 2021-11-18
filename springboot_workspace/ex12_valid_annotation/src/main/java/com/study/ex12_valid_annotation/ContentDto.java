package com.study.ex12_valid_annotation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ContentDto {
    private int id;
    @NotNull(message = "writer is null.")   // null 이면 안되고 null 이면 메세지를 출력한다
    @NotEmpty(message = "writer is empty.") // null 이면 안되고 null 이면 메세지를 출력한다
    @Size(min = 3, max = 10, message = "writer min 3, max 10.") // writer의 길이가 최소3 최대 10이라는 의미이고, 조건이 충족되지 않으면 메세지 출력
    private String writer;
    @NotNull(message = "content is null.")
    @NotEmpty(message = "content is empty.")
    private String content;
    
}
