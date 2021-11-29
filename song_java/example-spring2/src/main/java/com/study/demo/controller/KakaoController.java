package com.study.demo.controller;

import com.study.demo.configuration.properties.KakaoProperties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/kakao/*")
@RequiredArgsConstructor
public class KakaoController {
    
    // private final KakaoProperties properties;
    private final WebClient properties;

    // @GetMapping("/test")
    // @ResponseBody
    // public KakaoProperties test(){
    //     System.out.println("################ 카카오 테스트");
    //     return properties;
    // }

    @GetMapping("/search")
    public String search(@RequestParam String query){
        Mono<String> mono = properties.get()
        .uri(builder -> builder.path("/v2/local/search/address.json") // json 형식으로
        // https://developers.kakao.com/docs/latest/ko/local/dev-guide
        .queryParam("query", query) // 앞에 "query"는 카카오 API 에서 필수로 들어가야 하는 파라미터 이고 뒤에 있는 query는 파라미터 query
        .build()
        ) 
        .exchangeToMono(response -> {
            return response.bodyToMono(String.class);
        });
        return mono.block();
        
    }

    @GetMapping("coord2regioncode")
    public String coord2regioncode(@RequestParam String x, @RequestParam String y){
        Mono<String> mono = properties.get()
        .uri(builder -> builder.path("/v2/local/search/address.json") // json 형식으로
        .queryParam("x", x)
        .queryParam("y", y)
        .build()
        )
        .exchangeToMono(response -> {
            return response.bodyToMono(String.class);
        });
        return mono.block();
    }
}
