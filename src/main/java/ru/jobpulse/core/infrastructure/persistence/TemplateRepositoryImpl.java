package ru.jobpulse.core.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.jobpulse.core.domain.model.CoverLetterTemplate;
import ru.jobpulse.core.domain.repository.TemplateRepository;
import ru.jobpulse.core.infrastructure.persistence.entity.TemplateEntity;
import ru.jobpulse.core.infrastructure.persistence.mapper.TemplateMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class TemplateRepositoryImpl implements TemplateRepository {

    private final TemplateJpaRepository jpaRepository;
    private final TemplateMapper templateMapper;


    @Override
    public CoverLetterTemplate save(CoverLetterTemplate template) {
        TemplateEntity e = templateMapper.toEntity(template);
        return templateMapper.toDomain(jpaRepository.save(e));
    }

    @Override
    public Optional<CoverLetterTemplate> findById(UUID id) {
        return jpaRepository.findById(id).map(templateMapper::toDomain);
    }

    @Override
    public List<CoverLetterTemplate> findAll() {
        return jpaRepository.findAll().stream().map(templateMapper::toDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
