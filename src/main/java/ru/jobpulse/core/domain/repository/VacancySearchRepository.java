package ru.jobpulse.core.domain.repository;

import ru.jobpulse.core.domain.model.VacancyCount;

public interface VacancySearchRepository {
    VacancyCount findVacancyCount(String query);
}
