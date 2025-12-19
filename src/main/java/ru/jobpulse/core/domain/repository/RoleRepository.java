package ru.jobpulse.core.domain.repository;

import ru.jobpulse.core.domain.model.user.Role;
import ru.jobpulse.core.domain.model.user.RoleType;

public interface RoleRepository {
    Role getByType(RoleType type);
}
