package com.qusalsdn.springboot.springtodos.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String userName, String password) {
        boolean isValidUserName = userName.equalsIgnoreCase("qusalsdn");
        boolean isValidPassword = password.equalsIgnoreCase("0000");
        return isValidUserName && isValidPassword;
    }
}
