package ru.jobpulse.core.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.jobpulse.core.api.dto.CreateUserRequest;
import ru.jobpulse.core.api.dto.UserResponse;
import ru.jobpulse.core.domain.model.user.Role;
import ru.jobpulse.core.domain.model.user.RoleType;
import ru.jobpulse.core.domain.model.user.User;
import ru.jobpulse.core.domain.repository.RoleRepository;
import ru.jobpulse.core.domain.repository.UserRepository;
import ru.jobpulse.core.infrastructure.persistence.mapper.UserMapper;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;

    public UserResponse createUser(CreateUserRequest request) {

        Role userRole = roleRepository.getByType(RoleType.USER);

        User user = new User(
                UUID.randomUUID(),
                request.fio(),
                request.phoneNumber(),
                request.email(),
                passwordEncoder.encode(request.password()),
                Set.of(userRole),
                false
        );

        userRepository.save(user);
        return mapper.toUserResponse(user);
    }

    public UserResponse getById(UUID id) {
        return mapper.toUserResponse(
                userRepository.findById(id)
                        .orElseThrow(() -> new IllegalStateException("User not found"))
        );
    }

    public List<UserResponse> getAll() {
        return userRepository.findAll().stream()
                .map(mapper::toUserResponse)
                .toList();
    }
}