package com.sicred.poc.model;

import com.sicred.poc.model.id.VoteEntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Entidade para representar Votacao
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString@IdClass(VoteEntityId.class)
public class VoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Id
    @ManyToOne(targetEntity = AssociateEntity.class)
    @JoinColumn(name = "ID_ASSOCIATE", nullable = false)
    private AssociateEntity associate;

    @Id
    @ManyToOne(targetEntity = AgendaEntity.class)
    @JoinColumn(name = "ID_AGENDA", nullable = false)
    private AgendaEntity agenda;

    @Column(nullable = false)
    private String vote;
}


