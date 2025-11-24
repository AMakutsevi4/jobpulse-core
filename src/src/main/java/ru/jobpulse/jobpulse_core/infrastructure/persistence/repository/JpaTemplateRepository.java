package ru.jobpulse.jobpulse_core.infrastructure.persistence.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.jobpulse.jobpulse_core.domain.template.model.CoverLetterTemplate;
import ru.jobpulse.jobpulse_core.domain.template.model.TemplateRepository;
import ru.jobpulse.jobpulse_core.infrastructure.persistence.entity.TemplateEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Primary
@Transactional
@RequiredArgsConstructor
public class JpaTemplateRepository implements TemplateRepository {

    private final SpringDataTemplatesRepository repository;

    @Override
    public void save(CoverLetterTemplate templateEntity) {
        TemplateEntity template = new TemplateEntity(templateEntity.getId(), templateEntity.getTitle(), templateEntity.getContent());
        var saved = repository.save(template);
        new CoverLetterTemplate(saved.getId(), saved.getTitle(), saved.getContent());
    }

    @Override
    public Optional<CoverLetterTemplate> findById(UUID id) {
        return repository.findById(id).map(e -> new CoverLetterTemplate(e.getId(), e.getTitle(), e.getContent()));
    }

    @Override
    public List<CoverLetterTemplate> findAll() {
        return repository.findAll().stream()
                .map(e -> new CoverLetterTemplate(e.getId(), e.getTitle(), e.getContent()))
                .toList();
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}