package ru.jobpulse.jobpulse_core.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.jobpulse.jobpulse_core.application.template.TemplateService;
import ru.jobpulse.jobpulse_core.application.template.dto.TemplateUpdateRequest;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TemplateController {

    private final TemplateService templateService;

    @PutMapping("/{id}")
    public void update(@PathVariable UUID id, @RequestBody TemplateUpdateRequest request) {
        templateService.updateTemplate(id, request.title(), request.content());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        templateService.deleteTemplate(id);
    }
}
