package ru.jobpulse.jobpulse_core.api.template.dto;

import java.util.UUID;

public record TemplateResponse(
        UUID id,
        String template,
        String content
) {
}
