package ru.jobpulse.core.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(

        @NotBlank
        String fio,

        @NotBlank
        String phoneNumber,

        @Email
        @NotBlank
        String email,

        @NotBlank
        String password
) {}
