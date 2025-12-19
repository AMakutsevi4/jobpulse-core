package ru.jobpulse.core.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jobpulse.core.domain.model.user.RoleType;
import ru.jobpulse.core.infrastructure.persistence.entity.RoleEntity;

import java.util.Optional;
import java.util.UUID;

public interface RoleJpaRepository extends JpaRepository<RoleEntity, UUID> {
    Optional<RoleEntity> findByType(RoleType type);
}
