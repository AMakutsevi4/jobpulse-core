package ru.jobpulse.jobpulse_core.domain.template.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class CoverLetterTemplate {

    private final UUID id;
    private final String title;
    private final String content;
}
