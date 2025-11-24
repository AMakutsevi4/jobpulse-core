package ru.jobpulse.core.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.jobpulse.core.application.service.SearchVacanciesService;
import ru.jobpulse.core.domain.model.VacancyCount;

@RestController
public class HhSearchController {

    private final SearchVacanciesService service;

    public HhSearchController(SearchVacanciesService service) {
        this.service = service;
    }

    @GetMapping("/api/hh/search")
    public ResponseEntity<VacancyCount> search(@RequestParam String query) {
        VacancyCount vc = service.search(query);
        return ResponseEntity.ok(vc);
    }
}