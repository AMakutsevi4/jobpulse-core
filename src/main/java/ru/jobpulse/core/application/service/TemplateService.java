package ru.jobpulse.core.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jobpulse.core.api.exception.NotFoundException;
import ru.jobpulse.core.domain.model.CoverLetterTemplate;
import ru.jobpulse.core.domain.repository.TemplateRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TemplateService {

    private final TemplateRepository repository;

    public UUID createTemplate(String title, String content) {
        CoverLetterTemplate t = new CoverLetterTemplate(UUID.randomUUID(), title, content);
        repository.save(t);
        return t.id();
    }

    public CoverLetterTemplate getTemplate(UUID id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Template not found: " + id));
    }

    public List<CoverLetterTemplate> listTemplates() {
        return repository.findAll();
    }

    public void updateTemplate(UUID id, String title, String content) {
        getTemplate(id);
        repository.save(new CoverLetterTemplate(id, title, content));
    }

    public void deleteTemplate(UUID id) {
        getTemplate(id);
        repository.deleteById(id);
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
