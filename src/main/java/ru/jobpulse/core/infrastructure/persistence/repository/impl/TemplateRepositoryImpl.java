package ru.jobpulse.core.infrastructure.persistence.repository.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.jobpulse.core.domain.model.CoverLetterTemplate;
import ru.jobpulse.core.domain.repository.TemplateRepository;
import ru.jobpulse.core.infrastructure.persistence.entity.TemplateEntity;
import ru.jobpulse.core.infrastructure.persistence.mapper.TemplateMapper;
import ru.jobpulse.core.infrastructure.persistence.repository.TemplateJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TemplateRepositoryImpl implements TemplateRepository {

    private final TemplateJpaRepository jpaRepository;
    private final TemplateMapper templateMapper;


    @Override
    public CoverLetterTemplate save(CoverLetterTemplate template) {
        log.debug("Saving template id={}", template.id());
        TemplateEntity e = templateMapper.toEntity(template);
        return templateMapper.toDomain(jpaRepository.save(e));
    }

    @Override
    public Optional<CoverLetterTemplate> findById(UUID id) {
        log.debug("Find template by id={}", id);
        return jpaRepository.findById(id).map(templateMapper::toDomain);
    }

    @Override
    public List<CoverLetterTemplate> findAll() {
        log.debug("Find all templates");
        return jpaRepository.findAll().stream().map(templateMapper::toDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("Delete template id={}", id);
        jpaRepository.deleteById(id);
    }
}
