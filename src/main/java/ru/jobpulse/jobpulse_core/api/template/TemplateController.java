package ru.jobpulse.jobpulse_core.api.template;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.jobpulse.jobpulse_core.api.template.dto.TemplateCreateRequest;
import ru.jobpulse.jobpulse_core.api.template.dto.TemplateResponse;
import ru.jobpulse.jobpulse_core.application.template.TemplateService;

import java.util.UUID;

@RestController
@RequestMapping("/api/templates")
@RequiredArgsConstructor
public class TemplateController {

    private final TemplateService service;

    @PostMapping
    public UUID createTemplate(@RequestBody TemplateCreateRequest request) {
        return service.createTemplate(request.title(), request.content());
    }

    @GetMapping("/{id}")
    public TemplateResponse getTemplate(@PathVariable UUID id) {
        var template = service.getTemplate(id);
        return new TemplateResponse(template.getId(), template.getTitle(), template.getContent());
    }

}
