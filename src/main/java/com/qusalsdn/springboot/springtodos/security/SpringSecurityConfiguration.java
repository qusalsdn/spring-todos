package com.qusalsdn.springboot.springtodos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

//SpringSecurityy는 기본적으로 로그아웃 URL을 제공한다.
@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input); // 람다 함수로 username, password를 passwordEncoder 함수를 통하여 BCryptPasswordEncoder로 변환
        UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username("qusalsdn").password("0000").roles("USER", "ADMIN").build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}