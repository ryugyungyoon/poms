package com.jg.poms.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  //Spring Boot에서 이 클래스를 Configuration 파일로 인식
@EnableWebSecurity //Spring Security 설정을 시작
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //스프링 시큐리티 기능 비활성화
    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring()
                .requestMatchers("/images/**", "/js/**", "/css/**", "/font/**", "/error");
                //.requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    //특정 HTTP 요청에 대한 웹 기반 보안 구성
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                    //.requestMatchers() : 특정 경로에 특정 작업을 설정시 사용하는 메소드.
                    // 이 메소드에 경로 입력 후 하위 메소드 이용하여 접근 수준을 설정한다.
                    //.permitAll() : 모든 사용자에 대해 로그인하지 않아도 접근 허용
                    //.hasRole() : 특정한 Role에게만 접근 허용
                    //.hasAnyRole() : 인자에 적어준 여러 Role들에게 접근 허용
                    //.authenticated() : 로그인만 하면 접근 허용
                    //.denyAll() : 모든 사용자에 대해 로그인해도 접근 불가
                    .requestMatchers("/", "/user/login-form").permitAll()
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    //.anyRequest() : 위에서 처리하지 못한 나머지 경로에 대한 처리
                    //.authenticated()나 .denyAll()로 설정하는 것이 일반적
                    .anyRequest().authenticated()
                    //위에서부터 아래의 순서로 적용되므로 가장 아래에서 모든 경로에 대한 설정을 진행해야 함
                );
        http
                .formLogin((formLogin) ->
                        //로그인 폼 페이지 설정 - 접근 불가 페이지 접근시 자동으로 해당 경로로 리다이렉션 진행
                        formLogin.loginPage("/user/login-form")
                                //로그인 폼에서 로그인 요청시 url 설정
                                //이 url 요청 시 스프링 시큐리티가 가로채서 UserDetailsService의 loadUserByUsername 메서드로 연결
                                .loginProcessingUrl("/user/login")
                                //로그인 성공시 url
                                .defaultSuccessUrl("/", true)
                                //로그인 실패시 url
                                .failureUrl("/user/login-form")
                                //아이디 파라미터명 설정
                                .usernameParameter("id")
                                //패스워드 파라미터명 설정
                                .passwordParameter("pw")
                                .permitAll()

                );
        http
                //사이트 위변조 방지 csrf disable로 설정. default인 enable 설정시에는 post 요청시 csrf token 전달 필수(전달 안하면 로그인 진행 안됨)
                .csrf(AbstractHttpConfigurer::disable);
    /*
                .formLogin((formLogin) ->
                        formLogin.loginPage("/user/login-form")
                                .defaultSuccessUrl("/main")
                )
                .logout((logout) ->
                        logout.logoutSuccessUrl("/user/login-form")
                                .invalidateHttpSession(true)
                )

    */
                //default는 enable, csrf disable로 미설정시 post 요청시 csrf token 전달 필수
                //.csrf(AbstractHttpConfigurer::disable)
        return http.build();
    }
}
