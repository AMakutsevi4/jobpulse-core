package ru.jobpulse.core.infrastructure.client;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.jobpulse.core.domain.model.VacancyCount;
import ru.jobpulse.core.domain.repository.VacancySearchRepository;

@Repository
@Profile("prod")
@RequiredArgsConstructor
public class HhVacancySearchRepository implements VacancySearchRepository {

    private final HhApiClient client;

    @Override
    public VacancyCount findVacancyCount(String query) {
        int c = client.getVacanciesCount(query);
        return new VacancyCount(query, c);
    }
}