package ru.jobpulse.core.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.jobpulse.core.domain.model.user.Role;
import ru.jobpulse.core.domain.model.user.User;
import ru.jobpulse.core.infrastructure.persistence.entity.RoleEntity;
import ru.jobpulse.core.infrastructure.persistence.entity.UserEntity;

import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toDomain(UserEntity entity);

    UserEntity toEntity(User domain);

    Role toDomain(RoleEntity entity);

    RoleEntity toEntity(Role domain);

    Set<Role> toDomainRoles(Set<RoleEntity> roles);

    Set<RoleEntity> toEntityRoles(Set<Role> roles);
}
