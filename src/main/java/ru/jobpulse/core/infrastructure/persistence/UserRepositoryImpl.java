package ru.jobpulse.core.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.jobpulse.core.domain.model.user.User;
import ru.jobpulse.core.domain.repository.UserRepository;
import ru.jobpulse.core.infrastructure.persistence.mapper.UserMapper;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository jpaRepository;
    private final UserMapper mapper;

    @Override
    public User save(User user) {
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(user))
        );
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }
}