package ru.jobpulse.jobpulse_core.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.jobpulse.jobpulse_core.application.service.VacancySearchService;
import ru.jobpulse.jobpulse_core.domain.model.VacancyCount;

@RestController
@RequiredArgsConstructor
public class HhSearchController {

    private final VacancySearchService service;


    @GetMapping("api/hh/search")
    public VacancyCount search(@RequestParam String query) {
        return service.search(query);
    }
}
