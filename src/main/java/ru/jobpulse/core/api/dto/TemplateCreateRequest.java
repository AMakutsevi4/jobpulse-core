package ru.jobpulse.core.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TemplateCreateRequest(
        @NotBlank(message = "Заголовок не должен быть пустым.")
        @Size(max = 100, message = "Заголовок слишком длинный")
        String title,

        @NotBlank(message = "Содержание не может быть пустым.")
        @Size(max = 5000, message = "Содержание слишком длинное")
        String content) {
}
