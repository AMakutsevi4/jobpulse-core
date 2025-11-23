package ru.jobpulse.jobpulse_core.application.template;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jobpulse.jobpulse_core.domain.template.model.CoverLetterTemplate;
import ru.jobpulse.jobpulse_core.domain.template.model.TemplateRepository;

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
}
