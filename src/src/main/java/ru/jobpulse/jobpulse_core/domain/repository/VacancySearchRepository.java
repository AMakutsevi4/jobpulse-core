package ru.jobpulse.jobpulse_core.domain.repository;

import ru.jobpulse.jobpulse_core.domain.model.VacancyCount;

public interface VacancySearchRepository {
    VacancyCount fingVacancyCount(String query);
}
