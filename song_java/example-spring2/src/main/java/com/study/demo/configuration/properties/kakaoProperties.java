package com.study.demo.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties
public class kakaoProperties {
    
    public String restapi;
    public String JavaScript;
    public String clientSecret;
}
