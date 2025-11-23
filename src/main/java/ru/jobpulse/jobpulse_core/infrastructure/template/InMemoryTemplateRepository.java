package ru.jobpulse.jobpulse_core.infrastructure.template;

import org.springframework.stereotype.Repository;
import ru.jobpulse.jobpulse_core.domain.template.model.CoverLetterTemplate;
import ru.jobpulse.jobpulse_core.domain.template.model.TemplateRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InMemoryTemplateRepository implements TemplateRepository {

    private final Map<UUID, CoverLetterTemplate> storage = new HashMap<>();

    @Override
    public CoverLetterTemplate save(CoverLetterTemplate template) {
        storage.put(template.getId(), template);
        return template;
    }

    @Override
    public Optional<CoverLetterTemplate> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }
}
