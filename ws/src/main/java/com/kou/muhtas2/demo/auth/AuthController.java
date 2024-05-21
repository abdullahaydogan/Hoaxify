package com.kou.muhtas2.demo.auth;

import com.kou.muhtas2.demo.auth.dto.AuthResponse;
import com.kou.muhtas2.demo.auth.dto.Credentials;
import com.kou.muhtas2.demo.shared.GenericMessage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @Autowired
    AuthService authService;

    @PostMapping("/api/v1/users/auth")
    AuthResponse handleAuthentication(@Valid @RequestBody Credentials credentials) {
        return authService.authenticate(credentials);
    }

    @PostMapping("/api/v1/users/logout")
    GenericMessage handleLogOut(@RequestHeader(name = "Authorization", required = false) String authorizationHeader) {
        authService.logout(authorizationHeader);
        return new GenericMessage("Logout Success");
    }

}
