package ru.jobpulse.core.domain.model;

import java.util.UUID;

public record CoverLetterTemplate(UUID id, String title, String content) {
}