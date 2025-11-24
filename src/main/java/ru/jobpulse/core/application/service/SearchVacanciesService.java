package ru.jobpulse.core.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jobpulse.core.domain.model.VacancyCount;
import ru.jobpulse.core.domain.repository.VacancySearchRepository;

@Service
@RequiredArgsConstructor
public class SearchVacanciesService {

    private final VacancySearchRepository vacancySearchRepository;

    public VacancyCount search(String query) {
        return vacancySearchRepository.findVacancyCount(query);
    }
}
