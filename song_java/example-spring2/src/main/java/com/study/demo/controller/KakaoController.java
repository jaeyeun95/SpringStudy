package com.study.demo.controller;

import com.study.demo.configuration.properties.KakaoProperties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/kakao/*")
@RequiredArgsConstructor
public class KakaoController {
    
    private final KakaoProperties properties;

    @GetMapping("/test")
    @ResponseBody
    public KakaoProperties test(){
        System.out.println("################ 카카오 테스트");
        return properties;
    }
}
