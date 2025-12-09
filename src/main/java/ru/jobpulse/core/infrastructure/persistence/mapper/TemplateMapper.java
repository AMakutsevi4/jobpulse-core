package ru.jobpulse.core.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.jobpulse.core.domain.model.CoverLetterTemplate;
import ru.jobpulse.core.infrastructure.persistence.entity.TemplateEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TemplateMapper {
    CoverLetterTemplate toDomain(TemplateEntity entity);

    TemplateEntity toEntity(CoverLetterTemplate domain);
}
