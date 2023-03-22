package com.sicred.poc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**
 * Entidade para representar Pauta
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descriptionAgenda;

}
