package com.sicred.poc.template;

import com.sicred.poc.external.dto.VotingDTO;
import com.sicred.poc.external.dto.VotingSavedDTO;
import com.sicred.poc.model.VotingEntity;

public class VotingTemplate {

    public static VotingSavedDTO validVotingSavedDTO() {
        return VotingSavedDTO.builder()
                .agendaSaveDTO(AgendaTemplate.validAgendaSaveDTO())
                .associateSaveDTO(AssociateTemplate.validAssociateSaveDTO())
                .vote("sim")
                .build();
    }

    public static VotingEntity validVotingEntity() {
        return VotingEntity.builder()
                .agenda(AgendaTemplate.validAgendaEntity())
                .associate(AssociateTemplate.validAssociateEntity())
                .vote("sim")
                .build();
    }

    public static VotingDTO validVotingDTO() {
        return VotingDTO.builder()
                .agendaDTO(AgendaTemplate.validAgendaDTO())
                .voteYes("5")
                .voteNo("3")
                .build();
    }
}
