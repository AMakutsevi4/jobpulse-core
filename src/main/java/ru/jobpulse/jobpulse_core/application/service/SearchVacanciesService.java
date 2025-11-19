package ru.jobpulse.jobpulse_core.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jobpulse.jobpulse_core.domain.model.VacancyCount;
import ru.jobpulse.jobpulse_core.domain.repository.VacancySearchRepository;

@Service
@RequiredArgsConstructor
public class SearchVacanciesService {

    private final VacancySearchRepository vacancySearchRepository;


    public VacancyCount search(String query) {
        return vacancySearchRepository.fingVacancyCount(query);
    }
}
