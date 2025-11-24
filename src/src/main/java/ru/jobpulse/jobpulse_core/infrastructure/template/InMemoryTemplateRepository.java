package ru.jobpulse.jobpulse_core.infrastructure.template;

import org.springframework.stereotype.Repository;
import ru.jobpulse.jobpulse_core.domain.template.model.CoverLetterTemplate;
import ru.jobpulse.jobpulse_core.domain.template.model.TemplateRepository;

import java.util.*;

@Repository
public class InMemoryTemplateRepository implements TemplateRepository {

    private final Map<UUID, CoverLetterTemplate> storage = new HashMap<>();

    @Override
    public void save(CoverLetterTemplate template) {
        storage.put(template.getId(), template);
    }

    @Override
    public Optional<CoverLetterTemplate> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<CoverLetterTemplate> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(UUID id) {
        storage.remove(id);
    }
}
