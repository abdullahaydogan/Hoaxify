package com.kou.muhtas2.demo.auth.token;

import com.kou.muhtas2.demo.auth.dto.Credentials;
import com.kou.muhtas2.demo.user.User;
import org.springframework.stereotype.Service;


@Service
public interface TokenService {
    public Token createToken(User user, Credentials credentials);

    public User verifyToken(String authorizationHeader);

    public void logout(String authorizationHeader);

}
