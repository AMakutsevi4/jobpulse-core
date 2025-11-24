package ru.jobpulse.core.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.jobpulse.core.api.dto.TemplateCreateRequest;
import ru.jobpulse.core.api.dto.TemplateResponse;
import ru.jobpulse.core.application.service.TemplateService;
import ru.jobpulse.core.domain.model.CoverLetterTemplate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/templates")
public class TemplateController {

    private final TemplateService service;

    public TemplateController(TemplateService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UUID> createTemplate(@RequestBody TemplateCreateRequest request) {
        UUID id = service.createTemplate(request.title(), request.content());
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemplateResponse> getTemplate(@PathVariable UUID id) {
        CoverLetterTemplate t = service.getTemplate(id);
        return ResponseEntity.ok(new TemplateResponse(t.id(), t.title(), t.content()));
    }

    @GetMapping
    public ResponseEntity<List<TemplateResponse>> listTemplates() {
        List<TemplateResponse> list = service.listTemplates().stream()
                .map(t -> new TemplateResponse(t.id(), t.title(), t.content()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTemplate(@PathVariable UUID id, @RequestBody TemplateCreateRequest req) {
        service.updateTemplate(id, req.title(), req.content());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTemplate(@PathVariable UUID id) {
        service.deleteTemplate(id);
        return ResponseEntity.noContent().build();
    }

    public static record GenerateRequest(String candidateName, java.util.List<String> skills) {
    }

    @PostMapping("/{id}/generate")
    public ResponseEntity<String> generate(@PathVariable UUID id, @RequestBody GenerateRequest req) {
        String res = service.generateLetter(id, req.candidateName(), req.skills());
        return ResponseEntity.ok(res);
    }
}