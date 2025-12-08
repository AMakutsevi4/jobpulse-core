package ru.jobpulse.core.infrastructure.template;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.jobpulse.core.domain.model.CoverLetterTemplate;
import ru.jobpulse.core.domain.repository.TemplateRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Primary
public class InMemoryTemplateRepository implements TemplateRepository {
    private final Map<UUID, CoverLetterTemplate> storage = new ConcurrentHashMap<>();

    @Override
    public CoverLetterTemplate save(CoverLetterTemplate template) {
        storage.put(template.id(), template);
        return template;
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
