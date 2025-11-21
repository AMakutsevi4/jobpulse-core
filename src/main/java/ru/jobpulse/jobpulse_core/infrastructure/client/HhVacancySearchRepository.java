package ru.jobpulse.jobpulse_core.infrastructure.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.jobpulse.jobpulse_core.domain.model.VacancyCount;
import ru.jobpulse.jobpulse_core.domain.repository.VacancySearchRepository;

@Repository
@RequiredArgsConstructor
public class HhVacancySearchRepository implements VacancySearchRepository {

    private final HhApiClient hhApiClient;

    @Override
    public VacancyCount fingVacancyCount(String query) {
        int count = hhApiClient.getVacanciesCount(query);
        return new VacancyCount(query, count);
    }
}
