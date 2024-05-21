package com.kou.muhtas2.demo.auth.dto;

import com.kou.muhtas2.demo.auth.token.Token;
import com.kou.muhtas2.demo.user.dto.UserDTO;

public class AuthResponse {
    UserDTO user;

    Token token;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
