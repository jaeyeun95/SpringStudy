package com.example.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity // 스프링 시큐리티 사용을 위한 어노테이션 선언
@RequiredArgsConstructor
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    // private final TokenProvider tokenProvider;
    // private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    // private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    
    @Autowired
    // CustomUserDetailsService userDetailsService;
    
    // 시큐리티 의 내장 객체 비밀번호의 암호화를 담당
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    // 스프링 시큐리티 룰을 무시하게 하는 Url 규칙(여기 등록시 규칙 적용 안함)
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        // .antMatchers("/**")
            .antMatchers("/resources/**")
            .antMatchers("/css/**")
            .antMatchers("/fonts/**")
            .antMatchers("/vendor/**")
            .antMatchers("/js/**")
            .antMatchers("/img/**")
            .antMatchers("/index.html")
            .antMatchers("/favicon.ico")
            ;
        }
        // 무시 하고 규칙 같이 설정시 무시 가 우선순위가 높음
        
        // 스프링 시큐리티 규칙 
    //     @Override
    //     protected void configure(HttpSecurity http) throws Exception {
    //         //csrf 보안 설정을 비활성화
    //         // 해당 기능을 사용하기 위해서는 프론트에서 csrf 토큰값을 보내줘야함
    //         http.csrf().disable()
            
    //         // exception handling 할 때 우리가 만든 클래스를 추가
    //         .exceptionHandling()
    //             .authenticationEntryPoint(jwtAuthenticationEntryPoint)
    //             .accessDeniedHandler(jwtAccessDeniedHandler)
            
    //         // 시큐리티는 기본적으로 세션을 사용
    //         // 여기서는 세션을 사용하지 않기 때문에 세션 설정을 Stateless 로 설정
    //     .and()   
    //         .sessionManagement()
    //         .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    //     .and()
    //         .cors()
    //     .and()
    //     .authorizeRequests() // 보호된 리소스 URL 에 접근할 수 있는 권한을 설정
    //         .antMatchers("/").permitAll() // 인증 관련
    //         .antMatchers("/auth/**").permitAll() // 인증 관련
    //         .antMatchers("/rasa/msg").permitAll() // 라사 메시지 통신부분
    //         .antMatchers("/login").permitAll() // 뷰라우팅 (로그인)
    //         .antMatchers("/adminAPI/programInfo").permitAll()
    //         // .antMatchers("/rasa/getTrainData").permitAll() // 라사 훈련 데이터
    //         // .antMatchers("/stt/**").permitAll() // STT
    //         .antMatchers("/admin/**").permitAll() // 뷰라우팅
    //         .antMatchers("/chatroom").permitAll() // 채팅 UI
    //         // .antMatchers("/extanal/**").permitAll() // 외부 -> 클라이언트 메시지
    //         .antMatchers("/ws/**").permitAll() //프론트 - 스프링 소켓연결 : 
    //         // .anyRequest().permitAll() // 나머지 요청들에 경우 : 인증을 요구
    //         .anyRequest().authenticated() // 나머지 요청들에 경우 : 인증을 요구
    //         .and()
    //         .apply(new JwtSecurityConfig(tokenProvider))
    //         ;
    // }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOriginPattern("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
