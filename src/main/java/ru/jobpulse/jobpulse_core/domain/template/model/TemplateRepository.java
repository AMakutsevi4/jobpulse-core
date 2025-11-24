package ru.jobpulse.jobpulse_core.domain.template.model;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TemplateRepository {
    CoverLetterTemplate save (CoverLetterTemplate template);

    Optional<CoverLetterTemplate> findById(UUID id);
}
