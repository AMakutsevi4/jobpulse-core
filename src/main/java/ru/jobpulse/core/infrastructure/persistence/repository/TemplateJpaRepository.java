package ru.jobpulse.core.infrastructure.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.jobpulse.core.infrastructure.persistence.entity.TemplateEntity;

import java.util.UUID;

public interface TemplateJpaRepository extends JpaRepository<TemplateEntity, UUID> {
}
