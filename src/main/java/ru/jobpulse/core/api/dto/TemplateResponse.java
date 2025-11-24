package ru.jobpulse.core.api.dto;

import java.util.UUID;

public record TemplateResponse(UUID id, String title, String content) {
}
