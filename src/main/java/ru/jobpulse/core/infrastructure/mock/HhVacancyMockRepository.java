package ru.jobpulse.core.infrastructure.mock;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.jobpulse.core.domain.model.VacancyCount;
import ru.jobpulse.core.domain.repository.VacancySearchRepository;

import java.util.Random;

@Repository
@Profile("dev")
@RequiredArgsConstructor
public class HhVacancyMockRepository implements VacancySearchRepository {

    private final Random random;

    @Override
    public VacancyCount findVacancyCount(String query) {
        return new VacancyCount(query, random.nextInt());
    }
}
