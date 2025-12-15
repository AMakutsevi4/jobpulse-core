package ru.jobpulse.core.api.dto;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String fio,
        String email,
        String phoneNumber
) {}
