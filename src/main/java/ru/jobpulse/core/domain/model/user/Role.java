package ru.jobpulse.core.domain.model.user;

import java.util.UUID;

public record Role(UUID id, RoleType type) {}