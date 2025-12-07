package ru.jobpulse.jobpulse_core.infrastructure.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class HhApiClient {

    private final RestClient client = RestClient.builder()
            .baseUrl("https://api.hh.ru")
            .build();

    public int getVacanciesCount(String query) {
        HhVacancyResponse response = client.get()
                .uri(uri -> uri.path("/vacancies")
                        .queryParam("text", query)
                        .build())
                .retrieve()
                .body(HhVacancyResponse.class);

        return response != null ? response.found() : 0;
    }

    public record HhVacancyResponse(int found) {}
}
