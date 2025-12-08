package ru.jobpulse.core.infrastructure.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class HhApiClient {

    private final WebClient webClient;

    public HhApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.hh.ru").build();
    }

    public int getVacanciesCount(String query) {
        try {
            Mono<HhResp> mono = webClient.get()
                    .uri(uri -> uri.path("/vacancies").queryParam("text", query).build())
                    .retrieve()
                    .bodyToMono(HhResp.class);

            HhResp resp = mono.block();
            return resp == null ? 0 : resp.found();
        } catch (Exception e) {
            System.err.println("HH API error: " + e.getMessage());
            return 0;
        }
    }

    public static record HhResp(int found) {
    }
}