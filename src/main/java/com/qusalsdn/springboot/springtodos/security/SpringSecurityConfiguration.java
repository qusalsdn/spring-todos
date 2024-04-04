package com.qusalsdn.springboot.springtodos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

//SpringSecurityy는 기본적으로 로그아웃 URL을 제공한다.
@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails1 = createNewUser("qusalsdn", "0000");
        UserDetails userDetails2 = createNewUser("qusalsdn123", "5555");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String userName, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input); // 람다 함수로 username, password를 passwordEncoder 함수를 통하여 BCryptPasswordEncoder로 변환
        UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(userName).password(password).roles("USER", "ADMIN").build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()); // 모든 요청 승인
        http.formLogin(Customizer.withDefaults()); // 승인되지 않은 요청이 있으면 formLogin을 설정해서 사용자 이름과 패스워드를 입력하는 페이지로 이동시킴
        http.csrf(csrf -> csrf.disable()); // CSRF 비활성화
        http.headers(header -> header.frameOptions(option -> option.disable())); // 프레임 비활성화
        return http.build();
    }
}
