package ru.jobpulse.jobpulse_core.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.jobpulse.jobpulse_core.application.template.TemplateService;
import ru.jobpulse.jobpulse_core.domain.template.model.TemplateRepository;

@Configuration
public class TemplateConfig {

    @Bean
    public TemplateService templateService(TemplateRepository repository) {
        return new TemplateService(repository);
    }
}
