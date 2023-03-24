package com.sicred.poc.template;

import com.sicred.poc.external.dto.VotingSavedDTO;

public class VotingTemplate {

    public static VotingSavedDTO validVotingSavedDTO() {
        return VotingSavedDTO.builder()
                .agendaSaveDTO(AgendaTemplate.validAgendaSaveDTO())
                .associateSaveDTO(AssociateTemplate.validAssociateSaveDTO())
                .vote("sim")
                .build();
    }

}
