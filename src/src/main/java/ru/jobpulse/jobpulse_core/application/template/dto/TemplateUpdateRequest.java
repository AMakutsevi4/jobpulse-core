package ru.jobpulse.jobpulse_core.application.template.dto;

public record TemplateUpdateRequest(
        String title,
        String content
) {
}