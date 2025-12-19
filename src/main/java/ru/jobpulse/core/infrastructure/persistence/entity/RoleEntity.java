package ru.jobpulse.core.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.jobpulse.core.domain.model.user.RoleType;

import java.util.UUID;

@Entity
@Table(name = "role")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private RoleType type;
}