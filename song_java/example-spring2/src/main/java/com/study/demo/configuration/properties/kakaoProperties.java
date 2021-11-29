package com.study.demo.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties
public class KakaoProperties {

    public String restapi;
    public String javaScript;
    public String clientSecret;

}
