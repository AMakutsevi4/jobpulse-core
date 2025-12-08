package ru.jobpulse.jobpulse_core.application.template;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jobpulse.jobpulse_core.domain.template.model.CoverLetterTemplate;
import ru.jobpulse.jobpulse_core.domain.template.model.TemplateRepository;
import ru.jobpulse.jobpulse_core.infrastructure.persistence.entity.TemplateEntity;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TemplateService {

    private final TemplateRepository repository;

    public UUID createTemplate(String title, String content) {
        CoverLetterTemplate template = new CoverLetterTemplate(UUID.randomUUID(), title, content);

        repository.save(template);
        return template.getId();
    }

    public CoverLetterTemplate getTemplate(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Template not found: " + id));
    }

    public List<CoverLetterTemplate> listTemplates() {
        return repository.findAll();
    }

    public void updateTemplate(UUID id, String title, String content) {
        CoverLetterTemplate existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Template not found: " + id));

        CoverLetterTemplate updated = new CoverLetterTemplate(
                existing.getId(),
                title,
                content
        );
        repository.save(updated);
    }

    public void deleteTemplate(UUID id) {
        repository.deleteById(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Template not found: " + id)).getId());
    }
}