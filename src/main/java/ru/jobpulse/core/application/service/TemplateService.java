package ru.jobpulse.core.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.jobpulse.core.api.exception.NotFoundException;
import ru.jobpulse.core.domain.model.CoverLetterTemplate;
import ru.jobpulse.core.domain.repository.TemplateRepository;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TemplateService {

    private final TemplateRepository repository;

    public UUID createTemplate(String title, String content) {
        log.info("Creating template: title={}", title);
        CoverLetterTemplate t = new CoverLetterTemplate(UUID.randomUUID(), title, content);
        repository.save(t);
        log.info("Template created id={}", t.id());
        return t.id();
    }

    public CoverLetterTemplate getTemplate(UUID id) {
        log.info("Get template: id={}", id);
        return repository.findById(id).orElseThrow(() -> {
            log.warn("Template not found id={}", id);
            return new NotFoundException("Template not found: " + id);
        });
    }

    public List<CoverLetterTemplate> listTemplates() {
        log.info("Find all templates");
        return repository.findAll();
    }

    public void updateTemplate(UUID id, String title, String content) {
        log.info("Updating template: id={}", id);
        getTemplate(id);
        repository.save(new CoverLetterTemplate(id, title, content));
        log.info("Template updated: id={}", id);
    }

    public void deleteTemplate(UUID id) {
        log.info("Deleting template: id={}", id);
        getTemplate(id);
        repository.deleteById(id);
        log.info("Template deleted: id={}", id);
    }

    public String generateLetter(UUID id, String candidateName, java.util.List<String> skills) {
        CoverLetterTemplate template = getTemplate(id);
        String content = template.content();
        String skillsJoined = String.join(", ", skills == null ? java.util.List.of() : skills);
        content = content.replace("{{name}}", candidateName == null ? "" : candidateName);
        content = content.replace("{{skills}}", skillsJoined);
        String skillsList = (skills == null) ? "" : skills.stream().map(s -> "- " + s).collect(java.util.stream.Collectors.joining("\n"));
        content = content.replace("{{skills_list}}", skillsList);
        return content;
    }
}
