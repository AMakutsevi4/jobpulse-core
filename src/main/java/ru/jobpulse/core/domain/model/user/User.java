package ru.jobpulse.core.domain.model.user;

import lombok.Getter;

import java.util.Set;
import java.util.UUID;

@Getter
public class User {

    private final UUID id;
    private final String fio;
    private final String phoneNumber;
    private final String email;
    private final String passwordHash;
    private final Set<Role> roles;
    private final boolean deleted;

    public User(
            UUID id,
            String fio,
            String phoneNumber,
            String email,
            String passwordHash,
            Set<Role> roles,
            boolean deleted
    ) {
        this.id = id;
        this.fio = fio;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passwordHash = passwordHash;
        this.roles = roles;
        this.deleted = deleted;
    }

    public boolean isAdmin() {
        return roles.stream().anyMatch(r -> r.type() == RoleType.ADMIN);
    }
}