package ru.jobpulse.core.domain.repository;

import ru.jobpulse.core.domain.model.CoverLetterTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TemplateRepository {
    CoverLetterTemplate save(CoverLetterTemplate template);

    Optional<CoverLetterTemplate> findById(UUID id);

    List<CoverLetterTemplate> findAll();

    void deleteById(UUID id);
}
