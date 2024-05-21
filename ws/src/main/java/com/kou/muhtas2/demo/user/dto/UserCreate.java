package com.kou.muhtas2.demo.user.dto;

import com.kou.muhtas2.demo.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreate(
        @NotBlank
        String username,
        @NotBlank
        @Size
        String password,
        @NotBlank
        String email

) {
    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }
}
