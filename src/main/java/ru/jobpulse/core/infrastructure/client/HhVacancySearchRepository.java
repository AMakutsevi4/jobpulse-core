package ru.jobpulse.core.infrastructure.client;


import org.springframework.stereotype.Repository;
import ru.jobpulse.core.domain.model.VacancyCount;
import ru.jobpulse.core.domain.repository.VacancySearchRepository;

@Repository
public class HhVacancySearchRepository implements VacancySearchRepository {

    private final HhApiClient client;

    public HhVacancySearchRepository(HhApiClient client) {
        this.client = client;
    }

    @Override
    public VacancyCount findVacancyCount(String query) {
        int c = client.getVacanciesCount(query);
        return new VacancyCount(query, c);
    }
}