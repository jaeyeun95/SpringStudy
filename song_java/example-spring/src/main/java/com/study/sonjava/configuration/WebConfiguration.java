package com.study.sonjava.configuration;

import java.util.Locale;

import com.study.sonjava.configuration.servlet.handler.BaseHandlerInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    // 스프링에서 기본 제공해줌
    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:/messages/message");
        source.setDefaultEncoding("UTF-8");
        source.setCacheSeconds(60);
        source.setDefaultLocale(Locale.KOREAN);
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }

    @Bean
    public BaseHandlerInterceptor baseHandlerInterceptor(){
        return new BaseHandlerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(baseHandlerInterceptor());
    }

    
    
}
