package ru.jobpulse.core.infrastructure.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Random;

@Configuration
@Profile("dev")
public class AppConfig {
    @Bean
    public Random random() {
        return new Random();
    }
}