package com.study.demo.configuration;

import com.study.demo.configuration.properties.KakaoProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class KakaoConfiguration {

    private final KakaoProperties properties;

    @Bean
    public WebClient kakaoClient(){
        return WebClient.builder().baseUrl("https://dapi.kakao.com")
        .defaultHeader("Authorization", "KakaoAK " + properties.getRestapi()).build();
    }
    
}
