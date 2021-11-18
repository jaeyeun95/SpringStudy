package com.study.springboot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // url 요청에 대한 허용여부를 설정한다.
        // 만약 겹치는 부분이 있다면 뒤의 설정이 앞의 설정 내용을 계속해서 덮어 쓴다. 그래서 앞부분에서 가장 넓은
        // 범위로 허용 범위를 정하고 뒤에서 범위를 좁혀 부분적으로 다시 지정하는 방식을 취한다.
        http.authorizeRequests()
            .antMatchers("/").permitAll()   // 루트 요청에 대해 모두에게 허용하는 세팅
            .antMatchers("/css/**", "/js/**", "/img/**").permitAll()    // css, /js, /img 아래 모든 url 요청에 대해서는 허용
            .antMatchers("/guest/**").permitAll()
            .antMatchers("/member/**").hasAnyRole("USER", "ADMIN")  // member 아래 url 요청은 "USER"나, "ADMIN" 역할(role)을 가지고 있어야 한다는 세팅
            .antMatchers("/admin/**").hasAnyRole("ADMIN")   // amdin 아래의 요청은 'ADMIN' 역할을 가지고 있어야 한다는 세팅
            .anyRequest().authenticated();

            http.formLogin()    // 로그인 폼 url은 모두에게 허용
                .permitAll();
        
            http.logout()       // 로그아웃 폼 url은 모두에게 허용
                .permitAll();
    }

    // 빠른 테스트를 위해 등록이 간단한 인메모리(inmemory) 방식의 인증 사용자를 등록.
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
            .withUser("user").password(passwordEncoder().encode("1234"))    // 사용자 이름 : user, 비밀번호 : 1234, 역할(role)이름 : USER 등록
            .roles("USER")
            .and()
            .withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN");   // 사용자 이름 : admin, 비밀번호 : 1234, 역할(role)이름 : ADMIN 등록
            // ROLE_ADMIN 에서 ROLE_ 는 자동으로 붙는다.
    }

    // passwordEncoder() 추가
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    

    
}
