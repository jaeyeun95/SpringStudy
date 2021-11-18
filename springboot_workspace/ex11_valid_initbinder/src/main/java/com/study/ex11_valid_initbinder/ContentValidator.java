package com.study.ex11_valid_initbinder;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator{

    @Override
    public boolean supports(Class<?> arg0) {
        return ContentDto.class.isAssignableFrom(arg0); // 검증할 객체의 클래스 타입 정보
    }

    // 유효성을 검증하기 위한 본인의 코드를 작성하는 공간
    @Override
    public void validate(Object obj, Errors errors) {
        
        ContentDto dto = (ContentDto)obj;

        // String sWriter = dto.getWriter();
        // if(sWriter == null || sWriter.trim().isEmpty()){
        //     System.out.println("Writer is null or empty");
        //     errors.rejectValue("writer", "trouble");
        // }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "writer is empty. ");

        String sWriter = dto.getWriter();
        if( sWriter.length() < 3){
            errors.rejectValue("writer", "writer is too short.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "content is empty. ");

        // String sContent = dto.getContent();
        // if(sContent == null || sContent.trim().isEmpty()){
        //     System.out.println("Contents is null or empty");
        //     errors.rejectValue("content", "trouble");
        // }
    }
    
    
}
