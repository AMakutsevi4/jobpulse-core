package ru.jobpulse.core.domain.model.user;

import java.util.Set;
import java.util.UUID;


public class User {

    private final UUID id;
    private final String email;
    private final String passwordHash;
    private final Set<Role> roles;
    private final boolean deleted;

    public User(UUID id, String email, String passwordHash, Set<Role> roles, boolean deleted) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.roles = roles;
        this.deleted = deleted;
    }

    public UUID id() { return id; }
    public String email() { return email; }
    public Set<Role> roles() { return roles; }

    public boolean isAdmin() {
        return roles.stream().anyMatch(r -> r.name().equals("ADMIN"));
    }
}
