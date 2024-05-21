package com.kou.muhtas2.demo.auth;


import com.kou.muhtas2.demo.auth.dto.AuthResponse;
import com.kou.muhtas2.demo.auth.dto.Credentials;
import com.kou.muhtas2.demo.auth.exception.AuthenticationException;
import com.kou.muhtas2.demo.auth.token.Token;
import com.kou.muhtas2.demo.auth.token.TokenService;
import com.kou.muhtas2.demo.user.User;
import com.kou.muhtas2.demo.user.UserService;
import com.kou.muhtas2.demo.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    TokenService tokenService;
    @Autowired
    UserService userService;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthResponse authenticate(Credentials credentials) {
        User inDB = userService.findByEmail(credentials.email());
        if (inDB == null) throw new AuthenticationException();
        if (!passwordEncoder.matches(credentials.password(), inDB.getPassword())) throw new AuthenticationException();

        Token token = tokenService.createToken(inDB, credentials);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        authResponse.setUser(new UserDTO(inDB));
        return authResponse;

    }

    public void logout(String authorizationHeader) {
        tokenService.logout(authorizationHeader);
    }

    public User getAuthenticatedUser(String authorizationHeader) {
        return tokenService.verifyToken(authorizationHeader);
    }

}
