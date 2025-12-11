package ru.jobpulse.core.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.jobpulse.core.domain.model.VacancyCount;
import ru.jobpulse.core.domain.repository.VacancySearchRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchVacanciesService {

    private final VacancySearchRepository vacancySearchRepository;

    public VacancyCount search(String query) {
        log.info("Search vacancies request, query = {}", query);
        VacancyCount result = vacancySearchRepository.findVacancyCount(query);
        log.info("Search result: query={}, count={}", query, result.count());
        return result;
    }
}
