package com.kou.muhtas2.demo.user.dto;

import jakarta.validation.constraints.NotBlank;

public record UserUpdate(
        @NotBlank
        String username,
        String image
) {
}
