package ru.jobpulse.core.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jobpulse.core.domain.model.user.Role;
import ru.jobpulse.core.domain.model.user.User;
import ru.jobpulse.core.domain.repository.UserRepository;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * Создание пользователя ТОЛЬКО админом
     */
    public UUID createUser(User admin, String email, String passwordHash) {

        if (!admin.isAdmin()) {
            throw new IllegalStateException("Only admin can create users");
        }

        User user = new User(
                UUID.randomUUID(),
                email,
                passwordHash,
                Set.of(new Role(null, "USER")),
                false
        );

        userRepository.save(user);
        return user.id();
    }
}
