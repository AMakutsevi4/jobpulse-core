package ru.jobpulse.core.domain.repository;

import ru.jobpulse.core.domain.model.user.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    User save(User user);

    Optional<User> findByEmail(String email);

    Optional<User> findById(UUID id);
}

