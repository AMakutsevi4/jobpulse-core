package ru.jobpulse.core.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jobpulse.core.infrastructure.persistence.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
}
