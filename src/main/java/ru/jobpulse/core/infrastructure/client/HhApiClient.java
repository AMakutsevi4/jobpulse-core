package ru.jobpulse.core.infrastructure.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@Profile("prod")
public class HhApiClient {

    private final WebClient webClient;

    public HhApiClient(
            WebClient.Builder webClientBuilder, @Value("${hh.api-url}") String baseUrl) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    public int getVacanciesCount(String query) {
        log.info("Calling HH API, query ={}", query);
        try {
            Mono<HhResp> mono = webClient.get()
                    .uri(uri -> uri.path("/vacancies").queryParam("text", query).build())
                    .retrieve()
                    .bodyToMono(HhResp.class);

            HhResp resp = mono.block();
            int count = resp == null ? 0 : resp.found();
            log.info("HH API result, found ={}", count);
            return count;
        } catch (Exception e) {
            log.error("HH API error for query={}", query);
            System.err.println("HH API error: " + e.getMessage());
            return 0;
        }
    }

    public record HhResp(int found) {
    }
}