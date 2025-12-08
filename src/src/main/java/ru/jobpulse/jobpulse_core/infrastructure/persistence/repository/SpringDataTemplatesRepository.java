package ru.jobpulse.jobpulse_core.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jobpulse.jobpulse_core.infrastructure.persistence.entity.TemplateEntity;

import java.util.UUID;

@Repository
public interface SpringDataTemplatesRepository extends JpaRepository<TemplateEntity, UUID> {

}
