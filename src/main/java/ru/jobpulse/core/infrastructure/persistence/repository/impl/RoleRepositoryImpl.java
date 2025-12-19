package ru.jobpulse.core.infrastructure.persistence.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.jobpulse.core.domain.model.user.Role;
import ru.jobpulse.core.domain.model.user.RoleType;
import ru.jobpulse.core.domain.repository.RoleRepository;
import ru.jobpulse.core.infrastructure.persistence.mapper.UserMapper;
import ru.jobpulse.core.infrastructure.persistence.repository.RoleJpaRepository;

@Repository
@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepository {

    private final RoleJpaRepository jpaRepository;
    private final UserMapper mapper;

    @Override
    public Role getByType(RoleType type) {
        return jpaRepository.findByType(type)
                .map(mapper::toDomain)
                .orElseThrow(() -> new IllegalStateException("Role not found: " + type));
    }
}
